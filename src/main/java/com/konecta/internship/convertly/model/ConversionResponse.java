package com.konecta.internship.convertly.model;

import jakarta.validation.constraints.NotNull;

public class ConversionResponse {
    private double input, result;
    private String formula;
    @NotNull
    private String status;

    public ConversionResponse() {

    }

    public ConversionResponse(double input, double result, String formula, String status) {
        this.input = input;
        this.result = result;
        this.formula = formula;
        this.status = status;
    }

    public double getInput() {
        return input;
    }

    public double getResult() {
        return result;
    }

    public String getFormula() {
        return formula;
    }

    public String getStatus() {
        return status;
    }
}
