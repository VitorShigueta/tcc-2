
import CardIndicadores from './CardIndicador';
import CardPrecificacao from './CardPrecificacao';
import useAuthStore from '../services/useAuthStore';
import { useState, useEffect } from 'react';
import SalvarIcon from './SalvarIcon';
import AcaoService from '../services/acao.service';

const Analise = (props) => {
    const { isLoggedIn, login, logout } = useAuthStore();

    let acao = props.acao;

    function salvarAcao() {
        AcaoService.salvar(acao.ticker).then(response => {
            if (response.status == 200) {
                alert("Ação salva com sucesso!");
            } else {
                alert("Tente novamente mais tarde");
            }
        });
    }

    function excluirAcao() {
        AcaoService.excluir(acao.ticker).then(response => {
            if (response.status == 200) {
                alert("Ação removida das ações salvas com sucesso!");
            } else {
                alert("Erro ao remover ação das ações salvas, tente novamente mais tarde");
            }
        });
    } 

    useEffect(() => {

    }, []);

    let indicadores = acao.indicadores.map(indicador =>
        <>
            <CardIndicadores key={indicador.tipoIndicador} indicador={indicador} />
        </>
    );
    let precificacoes = acao.precificacaos.map(precificacao =>
        <>
            <CardPrecificacao key={precificacao.nome} precificacao={precificacao} />
        </>
    );

    return (
        <>
            <h2>{acao.ticker} - {acao.nome} {isLoggedIn ? <SalvarIcon salvarAcao={salvarAcao} excluirAcao={excluirAcao} salva={acao.salva} logado={isLoggedIn} /> : ""}
            </h2>
            <br />
            <h3>Indicadores</h3>
            <hr />
            <div className="cards-container">
                {indicadores}
            </div>
            <h3>Precificações</h3>
            <hr />
            <div className='cards-precificacoes-container'>
                {precificacoes}
            </div>
        </>
    );
}

export default Analise;
