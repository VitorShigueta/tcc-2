import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/acao/";

const getAcao = (ticker) => {
    return axios
      .get(API_URL + ticker,  {headers: authHeader()})
      .then((response) => {
        return response.data;
      });
};

const getAcoesSalvas = () => {
    return axios
        .get(API_URL + "getAllSalvas", {headers: authHeader()})
        .then((response) => {
          return response.data;
        });
}

const estaSalva = (ticker) => {
  return axios
        .get(API_URL + "salva/" + ticker, {headers: authHeader()})
        .then((response) => {
          return response.data;
        });
}

const salvar = (ticker) => {
  return axios
        .post(API_URL + "salvar",{
          "ticker":ticker,
        }, {headers: authHeader()})
        .then((response) => {
          return response;
        });
}

const excluir = (ticker) => {
  return axios
        .post(API_URL + "excluir",{
          "ticker":ticker,
        }, {headers: authHeader()})
        .then((response) => {
          return response;
        });
}

  const AcaoService = {
    getAcao,
    getAcoesSalvas,
    estaSalva,
    salvar,
    excluir
  }

  export default AcaoService;