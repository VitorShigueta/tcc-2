package com.tcc2backEnd.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class CashDividend {
    @JsonProperty("assetIssued")
    private String assetIssued;

    @JsonProperty("paymentDate")
    private LocalDateTime paymentDate;

    @JsonProperty("rate")
    private double rate;

    @JsonProperty("relatedTo")
    private String relatedTo;

    @JsonProperty("approvedOn")
    private LocalDateTime approvedOn;

    @JsonProperty("isinCode")
    private String isinCode;

    @JsonProperty("label")
    private String label;

    @JsonProperty("lastDatePrior")
    private LocalDateTime lastDatePrior;

    @JsonProperty("remarks")
    private String remarks;

    public String getAssetIssued() {
        return assetIssued;
    }

    public void setAssetIssued(String assetIssued) {
        this.assetIssued = assetIssued;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
    }

    public LocalDateTime getApprovedOn() {
        return approvedOn;
    }

    public void setApprovedOn(LocalDateTime approvedOn) {
        this.approvedOn = approvedOn;
    }

    public String getIsinCode() {
        return isinCode;
    }

    public void setIsinCode(String isinCode) {
        this.isinCode = isinCode;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalDateTime getLastDatePrior() {
        return lastDatePrior;
    }

    public void setLastDatePrior(LocalDateTime lastDatePrior) {
        this.lastDatePrior = lastDatePrior;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
