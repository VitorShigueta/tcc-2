import React, { useState, useEffect } from "react";
import AcaoService from "../services/acao.service";
import useAuthStore from "../services/useAuthStore";
import AcoesSalvas from "./AcoesSalvas";

const Home = () => {
  const [response, setResponse]     = useState([]);
  const { isLoggedIn, login, logout } = useAuthStore();

  useEffect(() => {
    AcaoService.getAcoesSalvas().then(response => {
			setResponse(response);
      console.log(response);
		});
  }, []);

  return (
    <div className="container"> 
      {isLoggedIn?<AcoesSalvas acoesSalvas={response} />:"Faça Login para ter acesso aos recursos"}
    </div>
  );
};

export default Home;