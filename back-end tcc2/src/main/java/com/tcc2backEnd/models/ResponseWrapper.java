package com.tcc2backEnd.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseWrapper {
    @JsonProperty("results")
    private List<Result> results;

    // Getters e Setters
    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
