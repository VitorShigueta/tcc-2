
const CardPrecificacao = (props) => {
    const precificacao = props.precificacao;
    let defaulCardClasses = " text-dark bg-light card card-precificacao mb-3";

    return (
        <>
            <div className={defaulCardClasses}>
                <div className="card-header">{precificacao.nome}</div>
                <div className="card-body valor-precificacao">
                            <div>
                                Preço: {precificacao.valor}
                            </div>
                            <div>
                                Taxa de desconto: {precificacao.taxaDesconto}
                            </div>         
                </div>
                <div className="card-footer text-muted">
                {precificacao.descricao}
            </div>
            </div>
        </>
    );
}

export default CardPrecificacao;