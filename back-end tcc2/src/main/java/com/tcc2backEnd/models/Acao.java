package com.tcc2backEnd.models;

import java.math.BigDecimal;
import java.util.List;

public class Acao {
    private String ticker;
    private BigDecimal valor;
    private String nome;
    private List<Indicador> indicadores;
    private List<Precificacao> precificacaos;
    private boolean salva;

    public boolean isSalva() {
        return salva;
    }

    public void setSalva(boolean salva) {
        this.salva = salva;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

    public List<Precificacao> getPrecificacaos() {
        return precificacaos;
    }

    public void setPrecificacaos(List<Precificacao> precificacaos) {
        this.precificacaos = precificacaos;
    }
}
