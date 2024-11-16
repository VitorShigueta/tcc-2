
const CardAcaoSalva = (props) => {
    let defaulCardClasses = "card card-indicador mb-3";
    return(
        <><div className={defaulCardClasses}>
        <div className="card-header">Ação</div>
        <div className="card-body ">
            {props.tickerDirec}     
        </div>
    </div></>
    );
}

export default CardAcaoSalva;