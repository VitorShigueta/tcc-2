import OverlayTrigger from 'react-bootstrap/OverlayTrigger';
import Tooltip from 'react-bootstrap/Tooltip';

const CardIndicadores = (props) => {
    const indicador = props.indicador;
    let defaulCardClasses = "card card-indicador mb-3";

    const renderTooltip = (props) => (
        <Tooltip id="button-tooltip" {...props}>
            {indicador.observacaoParecerIndicador}
        </Tooltip>
    );

    return (
        <>
            <div className={indicador.parecerIndicador ? "text-bg-success " + defaulCardClasses : "text-bg-danger " + defaulCardClasses}>
                <div className="card-header">{indicador.tipoIndicador}</div>
                <div className="card-body valor-indicador">
                            <div>
                                {indicador.valorIndicador}
                            </div>

                            <div>
                                <OverlayTrigger
                                    placement="right"
                                    delay={{ show: 250, hide: 400 }}
                                    overlay={renderTooltip}
                                >
                                    <i className="fa-solid fa-circle-exclamation"></i>
                                </OverlayTrigger>
                            </div>
                </div>
            </div>
        </>
    );
}

export default CardIndicadores;