
const SalvarIcon = ({salva,salvarAcao,excluirAcao}) => {

    return(
        <>
        {!salva ? (
        <i className="fa-regular fa-bookmark" onClick={salvarAcao}></i>
    ) : (
        <i className="fa-solid fa-bookmark" onClick={excluirAcao}></i>
    )}
        </>
    );
}

export default SalvarIcon;