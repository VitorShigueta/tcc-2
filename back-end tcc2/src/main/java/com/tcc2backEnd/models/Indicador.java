package com.tcc2backEnd.models;

import java.math.BigDecimal;

public class Indicador {
    private String tipoIndicador;
    private String valorIndicador;
    private Boolean parecerIndicador; //Bom, ruim
    private String observacaoParecerIndicador;

    public Indicador(String tipoIndicador, String valorIndicador, Boolean parecerIndicador, String observacaoParecerIndicador) {
        this.tipoIndicador = tipoIndicador;
        this.valorIndicador = valorIndicador;
        this.parecerIndicador = parecerIndicador;
        this.observacaoParecerIndicador = observacaoParecerIndicador;
    }

    public String getTipoIndicador() {
        return tipoIndicador;
    }

    public void setTipoIndicador(String tipoIndicador) {
        this.tipoIndicador = tipoIndicador;
    }

    public String getValorIndicador() {
        return valorIndicador;
    }

    public void setValorIndicador(String valorIndicador) {
        this.valorIndicador = valorIndicador;
    }

    public Boolean getParecerIndicador() {
        return parecerIndicador;
    }

    public void setParecerIndicador(Boolean parecerIndicador) {
        this.parecerIndicador = parecerIndicador;
    }

    public String getObservacaoParecerIndicador() {
        return observacaoParecerIndicador;
    }

    public void setObservacaoParecerIndicador(String observacaoParecerIndicador) {
        this.observacaoParecerIndicador = observacaoParecerIndicador;
    }
}
