package com.tcc2backEnd.models;

import java.math.BigDecimal;


public class Result {
    private String currency;
    private String shortName;
    private String longName;
    private double regularMarketChange;
    private double regularMarketChangePercent;
    private String regularMarketTime;
    private BigDecimal regularMarketPrice;
    private double regularMarketDayHigh;
    private String regularMarketDayRange;
    private double regularMarketDayLow;
    private double regularMarketVolume;
    private double regularMarketPreviousClose;
    private double regularMarketOpen;
    private String fiftyTwoWeekRange;
    private double fiftyTwoWeekLow;
    private double fiftyTwoWeekHigh;
    private String symbol;
    private DefaultKeyStatistics defaultKeyStatistics;
    private SummaryProfile summaryProfile;
    private FinancialData financialData;
    private double priceEarnings;
    private BigDecimal earningsPerShare;
    private String logourl;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public double getRegularMarketChange() {
        return regularMarketChange;
    }

    public void setRegularMarketChange(double regularMarketChange) {
        this.regularMarketChange = regularMarketChange;
    }

    public double getRegularMarketChangePercent() {
        return regularMarketChangePercent;
    }

    public void setRegularMarketChangePercent(double regularMarketChangePercent) {
        this.regularMarketChangePercent = regularMarketChangePercent;
    }

    public String getRegularMarketTime() {
        return regularMarketTime;
    }

    public void setRegularMarketTime(String regularMarketTime) {
        this.regularMarketTime = regularMarketTime;
    }

    public BigDecimal getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(BigDecimal regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public double getRegularMarketDayHigh() {
        return regularMarketDayHigh;
    }

    public void setRegularMarketDayHigh(double regularMarketDayHigh) {
        this.regularMarketDayHigh = regularMarketDayHigh;
    }

    public String getRegularMarketDayRange() {
        return regularMarketDayRange;
    }

    public void setRegularMarketDayRange(String regularMarketDayRange) {
        this.regularMarketDayRange = regularMarketDayRange;
    }

    public double getRegularMarketDayLow() {
        return regularMarketDayLow;
    }

    public void setRegularMarketDayLow(double regularMarketDayLow) {
        this.regularMarketDayLow = regularMarketDayLow;
    }

    public double getRegularMarketVolume() {
        return regularMarketVolume;
    }

    public void setRegularMarketVolume(double regularMarketVolume) {
        this.regularMarketVolume = regularMarketVolume;
    }

    public double getRegularMarketPreviousClose() {
        return regularMarketPreviousClose;
    }

    public void setRegularMarketPreviousClose(double regularMarketPreviousClose) {
        this.regularMarketPreviousClose = regularMarketPreviousClose;
    }

    public double getRegularMarketOpen() {
        return regularMarketOpen;
    }

    public void setRegularMarketOpen(double regularMarketOpen) {
        this.regularMarketOpen = regularMarketOpen;
    }

    public String getFiftyTwoWeekRange() {
        return fiftyTwoWeekRange;
    }

    public void setFiftyTwoWeekRange(String fiftyTwoWeekRange) {
        this.fiftyTwoWeekRange = fiftyTwoWeekRange;
    }

    public double getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public void setFiftyTwoWeekLow(double fiftyTwoWeekLow) {
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
    }

    public double getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public void setFiftyTwoWeekHigh(double fiftyTwoWeekHigh) {
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public DefaultKeyStatistics getDefaultKeyStatistics() {
        return defaultKeyStatistics;
    }

    public void setDefaultKeyStatistics(DefaultKeyStatistics defaultKeyStatistics) {
        this.defaultKeyStatistics = defaultKeyStatistics;
    }

    public SummaryProfile getSummaryProfile() {
        return summaryProfile;
    }

    public void setSummaryProfile(SummaryProfile summaryProfile) {
        this.summaryProfile = summaryProfile;
    }

    public FinancialData getFinancialData() {
        return financialData;
    }

    public void setFinancialData(FinancialData financialData) {
        this.financialData = financialData;
    }

    public double getPriceEarnings() {
        return priceEarnings;
    }

    public void setPriceEarnings(double priceEarnings) {
        this.priceEarnings = priceEarnings;
    }

    public BigDecimal getEarningsPerShare() {
        return earningsPerShare;
    }

    public void setEarningsPerShare(BigDecimal earningsPerShare) {
        this.earningsPerShare = earningsPerShare;
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }
}
