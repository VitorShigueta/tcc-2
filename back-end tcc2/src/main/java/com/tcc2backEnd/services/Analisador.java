package com.tcc2backEnd.services;

import com.tcc2backEnd.models.*;
import com.tcc2backEnd.models.Acao;
import com.tcc2backEnd.models.Indicador;
import com.tcc2backEnd.models.Precificacao;
import com.tcc2backEnd.models.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Analisador {

    public Acao analisarAcao(Result dadosAcao, boolean estaSalva) {
        Acao acao = new Acao();
        BigDecimal valor = BigDecimal.ZERO;
        MathContext mc = new MathContext(10);
        BigDecimal mult = new BigDecimal(100);
        acao.setTicker(dadosAcao.getSymbol());
        acao.setValor(dadosAcao.getFinancialData().getCurrentPrice());
        acao.setNome(dadosAcao.getShortName());
        acao.setSalva(estaSalva);
        //Indicadores
        List <Indicador> indicadores = new ArrayList<>();

        //indicador preço/lucro
        valor = new BigDecimal(dadosAcao.getPriceEarnings());
        indicadores.add(new Indicador("P/L",
                formatarDuasCasas(valor) + "",
                getParecerPL(valor),
                getExplicacaoParecerPL(valor)));

        //indicador margem bruta
        valor = new BigDecimal(dadosAcao.getFinancialData().getGrossMargins());
        indicadores.add(new Indicador("Margem Bruta",
                formatarDuasCasas(valor.multiply(mult,mc)) + "%",
                getParecerMargemBruta(valor),
                getExplicacaoParecerMargemBruta(valor)));

        //indicador margem liquida
        valor =  new BigDecimal(dadosAcao.getFinancialData().getProfitMargins());
        indicadores.add(new Indicador("Margem Liquida",
                formatarDuasCasas(valor.multiply(mult,mc)) + "%",
                getParecerMargemLiquida(valor),
                getExplicacaoParecerMargemLiquida(valor)));

        valor = dadosAcao.getFinancialData().getReturnOnEquity();
        indicadores.add(new Indicador("Retorno sobre Patrimônio Líquido",
                formatarDuasCasas(valor.multiply(mult,mc)) + "%",
                getParecerRoe(valor),
                getExplicacaoParecerRoe(valor)));
        acao.setIndicadores(indicadores);

        valor = dadosAcao.getFinancialData().getCurrentRatio();
        indicadores.add(new Indicador("Líquidez Corrente",
                formatarDuasCasas(valor) + "",
                getParecerLiqCorrente(valor),
                getExplicacaoParecerLiqCorrente(valor)));
        acao.setIndicadores(indicadores);

        List <Precificacao> precificacoes = new ArrayList<>();
        valor = getPrecificacaoGranham(dadosAcao.getEarningsPerShare(),dadosAcao.getRegularMarketPrice());
        precificacoes.add(new Precificacao("Metodo Granham",
                formatarDuasCasas(valor),
                        getTaxaDesconto(valor,dadosAcao.getRegularMarketPrice()),
                "A fórmula de Granham é ideal para ações que apresentam lucros constantes e um bom patrimônio líquido"));
        valor = dadosAcao.getDefaultKeyStatistics().getBookValue();
        precificacoes.add(new Precificacao("Valor contábil",
                formatarDuasCasas(valor),
                getTaxaDesconto(valor,dadosAcao.getRegularMarketPrice()),
                "Indica quanto a empresa vale do ponto de vista do patrimônio líquido, ideal para ações que tem seu preço alterado por motivos não recorrentes ou não estejam no radar do mercado"));
        acao.setPrecificacaos(precificacoes);
        return acao;
    }
    
    public boolean getParecerPL(BigDecimal pl) {
        if (pl.compareTo(new BigDecimal(25)) > 0) {
            return false;
        }
        if (pl.compareTo(new BigDecimal(0)) < 0) {
            return false;
        }
        return true;
    }

    public String getExplicacaoParecerPL(BigDecimal pl) {
        if (pl.compareTo(new BigDecimal(25)) > 0) {
            return "O pl possui um valor elevado, o que pode significar um grau maior de risco associado a ação, verificar margens e crescimento da receita";
        }
        if (pl.compareTo(new BigDecimal(0)) < 0) {
            return "O pl possui um valor inferior a zero, o que indica a incidência de prejuizos, verificar a possivel recorrência dos prejuizos";
        }
        return "O pl possui um valor atrativo para investimento, verificar a constância dos lucros e eventos não recorrentes que possam influênciar o preço";
    }

    public boolean getParecerMargemBruta(BigDecimal margem) {
        if (margem.compareTo(new BigDecimal(0.40)) < 0) {
            return false;
        }

        return true;
    }

    public String getExplicacaoParecerMargemBruta(BigDecimal margem) {
        if (margem.compareTo(new BigDecimal(0.40)) < 0) {
            return "A margem bruta apresenta um valor condinzente com empresas que atuam em setores altamente competitivos, comparar a receita bruta com outras empresas do mesmo setor";
        }

        return "A margem bruta apresenta um valor condinzente com empresas que possuem uma vantagem competitiva durável, comparar a receita bruta com outras empresas do mesmo setor ";
    }

    public boolean getParecerMargemLiquida(BigDecimal margem) {
        if (margem.compareTo(new BigDecimal(0.20)) < 0) {
            return false;
        }

        return true;
    }

    public String getExplicacaoParecerMargemLiquida(BigDecimal margem) {
        if (margem.compareTo(new BigDecimal(0.20)) < 0) {
            return "A margem liquida apresentada indica altas chances da empresa estar inserida em um setor de atuação altamente competitivo";
        }

        return "A margem liquida apresentada indica boas chances da empresa possuir uma vantagem competitiva de longo prazo";
    }

    public boolean getParecerRoe(BigDecimal roe) {
        if (roe.compareTo(new BigDecimal(0.15)) < 0) {
            return false;
        }
        return true;
    }

    public String getExplicacaoParecerRoe(BigDecimal roe) {
        if (roe.compareTo(new BigDecimal(0.15)) < 0) {
            return "O valor indica que a companhia não está gerando lucro de forma eficiente a partir dos próprios recursos";
        }
        return "O valor indica que a companhia está gerando lucro de forma eficiente a partir dos próprios recursos";
    }

    public boolean getParecerLiqCorrente(BigDecimal liqCorr) {
        if (liqCorr.compareTo(new BigDecimal(1.0)) < 0) {
            return false;
        }
        return true;
    }

    public String getExplicacaoParecerLiqCorrente(BigDecimal liqCorr) {
        if (liqCorr.compareTo(new BigDecimal(1.0)) < 0) {
            return "O valor indica que a empresa pode ter dificuldades em honrar suas obrigações financeiras de curto prazo";
        }
        return "O valor indica que a empresa tem facilidade em honrar com suas obrigações financeiras a curto prazo";
    }

    public BigDecimal getPrecificacaoGranham(BigDecimal lpa, BigDecimal vpa) {
        BigDecimal fator = new BigDecimal("22.5");
        MathContext mc = new MathContext(10);
        // Calcular 22,5 * LPA * VPA
        BigDecimal produto = fator.multiply(lpa, mc).multiply(vpa, mc);
        return produto.sqrt(mc);
    }

    public BigDecimal getTaxaDesconto(BigDecimal valor, BigDecimal price) {
        BigDecimal diferenca = valor.subtract(price); // Calcula a diferença
        BigDecimal taxaDesconto = diferenca.divide(valor, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));

        return taxaDesconto;
    }

    public BigDecimal formatarDuasCasas(BigDecimal valor) {
        return valor.setScale(2, RoundingMode.HALF_UP);
    }
}
