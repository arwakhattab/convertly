package com.konecta.internship.convertly.model;

import com.konecta.internship.convertly.enums.Category;
import com.konecta.internship.convertly.enums.Unit;
import jakarta.validation.constraints.NotNull;

public class ConversionRequest {
    @NotNull
    private String category;
    @NotNull
    private String fromUnit, toUnit;
    @NotNull
    private double value;

    public ConversionRequest() {

    }

    public ConversionRequest(String category, String fromUnit, String toUnit, double value) {
        this.category = category;
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public String getToUnit() {
        return toUnit;
    }

    public double getValue() {
        return value;
    }
}
