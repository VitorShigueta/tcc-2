package com.tcc2backEnd.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class DividendsData {
    @JsonProperty("cashDividends")
    private List<CashDividend> cashDividends;

    // Getters e setters

    public List<CashDividend> getCashDividends() {
        return cashDividends;
    }

    public void setCashDividends(List<CashDividend> cashDividends) {
        this.cashDividends = cashDividends;
    }
}
