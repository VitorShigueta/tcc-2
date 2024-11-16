package com.tcc2backEnd.models;

import java.math.BigDecimal;

public class FinancialData {
    private BigDecimal currentPrice;
    private double targetHighPrice;
    private double targetLowPrice;
    private double targetMeanPrice;
    private double targetMedianPrice;
    private double recommendationMean;
    private String recommendationKey;
    private int numberOfAnalystOpinions;
    private long totalCash;
    private double totalCashPerShare;
    private long ebitda;
    private long totalDebt;
    private double quickRatio;
    private BigDecimal currentRatio;
    private long totalRevenue;
    private double debtToEquity;
    private double revenuePerShare;
    private double returnOnAssets;
    private BigDecimal returnOnEquity;
    private long freeCashflow;
    private long operatingCashflow;
    private double revenueGrowth;
    private double grossMargins;
    private double ebitdaMargins;
    private double operatingMargins;
    private double profitMargins;
    private String financialCurrency;

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getTargetHighPrice() {
        return targetHighPrice;
    }

    public void setTargetHighPrice(double targetHighPrice) {
        this.targetHighPrice = targetHighPrice;
    }

    public double getTargetLowPrice() {
        return targetLowPrice;
    }

    public void setTargetLowPrice(double targetLowPrice) {
        this.targetLowPrice = targetLowPrice;
    }

    public double getTargetMeanPrice() {
        return targetMeanPrice;
    }

    public void setTargetMeanPrice(double targetMeanPrice) {
        this.targetMeanPrice = targetMeanPrice;
    }

    public double getTargetMedianPrice() {
        return targetMedianPrice;
    }

    public void setTargetMedianPrice(double targetMedianPrice) {
        this.targetMedianPrice = targetMedianPrice;
    }

    public double getRecommendationMean() {
        return recommendationMean;
    }

    public void setRecommendationMean(double recommendationMean) {
        this.recommendationMean = recommendationMean;
    }

    public String getRecommendationKey() {
        return recommendationKey;
    }

    public void setRecommendationKey(String recommendationKey) {
        this.recommendationKey = recommendationKey;
    }

    public int getNumberOfAnalystOpinions() {
        return numberOfAnalystOpinions;
    }

    public void setNumberOfAnalystOpinions(int numberOfAnalystOpinions) {
        this.numberOfAnalystOpinions = numberOfAnalystOpinions;
    }

    public long getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(long totalCash) {
        this.totalCash = totalCash;
    }

    public double getTotalCashPerShare() {
        return totalCashPerShare;
    }

    public void setTotalCashPerShare(double totalCashPerShare) {
        this.totalCashPerShare = totalCashPerShare;
    }

    public long getEbitda() {
        return ebitda;
    }

    public void setEbitda(long ebitda) {
        this.ebitda = ebitda;
    }

    public long getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(long totalDebt) {
        this.totalDebt = totalDebt;
    }

    public double getQuickRatio() {
        return quickRatio;
    }

    public void setQuickRatio(double quickRatio) {
        this.quickRatio = quickRatio;
    }

    public BigDecimal getCurrentRatio() {
        return currentRatio;
    }

    public void setCurrentRatio(BigDecimal currentRatio) {
        this.currentRatio = currentRatio;
    }

    public long getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(long totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public double getDebtToEquity() {
        return debtToEquity;
    }

    public void setDebtToEquity(double debtToEquity) {
        this.debtToEquity = debtToEquity;
    }

    public double getRevenuePerShare() {
        return revenuePerShare;
    }

    public void setRevenuePerShare(double revenuePerShare) {
        this.revenuePerShare = revenuePerShare;
    }

    public double getReturnOnAssets() {
        return returnOnAssets;
    }

    public void setReturnOnAssets(double returnOnAssets) {
        this.returnOnAssets = returnOnAssets;
    }

    public BigDecimal getReturnOnEquity() {
        return returnOnEquity;
    }

    public void setReturnOnEquity(BigDecimal returnOnEquity) {
        this.returnOnEquity = returnOnEquity;
    }

    public long getFreeCashflow() {
        return freeCashflow;
    }

    public void setFreeCashflow(long freeCashflow) {
        this.freeCashflow = freeCashflow;
    }

    public long getOperatingCashflow() {
        return operatingCashflow;
    }

    public void setOperatingCashflow(long operatingCashflow) {
        this.operatingCashflow = operatingCashflow;
    }

    public double getRevenueGrowth() {
        return revenueGrowth;
    }

    public void setRevenueGrowth(double revenueGrowth) {
        this.revenueGrowth = revenueGrowth;
    }

    public double getGrossMargins() {
        return grossMargins;
    }

    public void setGrossMargins(double grossMargins) {
        this.grossMargins = grossMargins;
    }

    public double getEbitdaMargins() {
        return ebitdaMargins;
    }

    public void setEbitdaMargins(double ebitdaMargins) {
        this.ebitdaMargins = ebitdaMargins;
    }

    public double getOperatingMargins() {
        return operatingMargins;
    }

    public void setOperatingMargins(double operatingMargins) {
        this.operatingMargins = operatingMargins;
    }

    public double getProfitMargins() {
        return profitMargins;
    }

    public void setProfitMargins(double profitMargins) {
        this.profitMargins = profitMargins;
    }

    public String getFinancialCurrency() {
        return financialCurrency;
    }

    public void setFinancialCurrency(String financialCurrency) {
        this.financialCurrency = financialCurrency;
    }
}
