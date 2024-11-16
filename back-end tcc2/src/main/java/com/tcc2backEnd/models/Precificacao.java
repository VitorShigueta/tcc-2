package com.tcc2backEnd.models;

import java.math.BigDecimal;

public class Precificacao {
    private String nome;
    private BigDecimal valor;
    private BigDecimal taxaDesconto;
    private String descricao;

    public Precificacao(String nome, BigDecimal valor, BigDecimal taxaDesconto, String descricao) {
        this.nome = nome;
        this.valor = valor;
        this.taxaDesconto = taxaDesconto;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTaxaDesconto() {
        return taxaDesconto;
    }

    public void setTaxaDesconto(BigDecimal taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
