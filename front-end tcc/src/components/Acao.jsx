
import AcaoService from "../services/acao.service";
import { useState } from "react";
import Analise from "./Analise";
import { useLocation } from "react-router-dom";
import { useEffect } from "react";
import useAuthStore from "../services/useAuthStore";

const Acao = () => {
	const [acao, setAcao]     = useState("");
	const [ticker, setTicker] = useState("");
	const { isLoggedIn, login, logout } = useAuthStore();

	function getAcaoFromApi() {
		AcaoService.getAcao(ticker).then(response => {
			setAcao(response);
		});
	}

	function getAcaoFromApiRedirec(ticker) {
		AcaoService.getAcao(ticker).then(response => {
			setAcao(response);
		});
	}

	useEffect(() => {
		if (ticker == "") {
			const params = new URLSearchParams(location.search);
			
			// Atribuir o valor do parâmetro 'ticker' ao estado
			const tickerParam = params.get('ticker');
			getAcaoFromApiRedirec(tickerParam);
		}
	  }, [location]); // O efeito será acionado sempre que a URL mudar

	  // Função handleChange para atualizar o valor
	const handleChange = (event) => {
		setTicker(event.target.value); // Atualiza o estado com o valor do campo de entrada
	};

	return (
		<>
			<div className="input-group mb-3">
				<input type="text" className="form-control" placeholder="Busque uma ação" aria-label="Recipient's username" aria-describedby="button-addon2" onChange={handleChange}/>
				<button className="btn btn-outline-secondary" type="button" id="button-addon2" onClick={getAcaoFromApi}>Buscar</button>
			</div>	

			{acao && <Analise acao={acao} />}
		</>
	);
}

export default Acao;