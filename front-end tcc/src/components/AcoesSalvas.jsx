import { Link } from "react-router-dom";
import CardAcaoSalva from "./CardAcaoSalva";

const AcoesSalvas = (props) => {

    let acoes = props.acoesSalvas.map(acao =>
        <>
            <Link to={`/acao?ticker=${acao.ticker}`}>
    <CardAcaoSalva key={acao.id} tickerDirec={acao.ticker} />
</Link>
        </>
    );
    return (
        <>
            <h3>Ações salvas</h3>
            <hr />
            <div className="cards-container">
            {acoes}
            </div>
        </>
    );
}

export default AcoesSalvas;