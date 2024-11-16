package com.tcc2backEnd.models;

import java.util.List;

public class SummaryProfile {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String website;
    private String industry;
    private String industryKey;
    private String industryDisp;
    private String sector;
    private String sectorKey;
    private String sectorDisp;
    private String longBusinessSummary;
    private int fullTimeEmployees;
    private List<String> companyOfficers;

    public List<String> getCompanyOfficers() {
        return companyOfficers;
    }

    public void setCompanyOfficers(List<String> companyOfficers) {
        this.companyOfficers = companyOfficers;
    }

    public int getFullTimeEmployees() {
        return fullTimeEmployees;
    }

    public void setFullTimeEmployees(int fullTimeEmployees) {
        this.fullTimeEmployees = fullTimeEmployees;
    }

    public String getLongBusinessSummary() {
        return longBusinessSummary;
    }

    public void setLongBusinessSummary(String longBusinessSummary) {
        this.longBusinessSummary = longBusinessSummary;
    }

    public String getSectorDisp() {
        return sectorDisp;
    }

    public void setSectorDisp(String sectorDisp) {
        this.sectorDisp = sectorDisp;
    }

    public String getSectorKey() {
        return sectorKey;
    }

    public void setSectorKey(String sectorKey) {
        this.sectorKey = sectorKey;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getIndustryDisp() {
        return industryDisp;
    }

    public void setIndustryDisp(String industryDisp) {
        this.industryDisp = industryDisp;
    }

    public String getIndustryKey() {
        return industryKey;
    }

    public void setIndustryKey(String industryKey) {
        this.industryKey = industryKey;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }
}
