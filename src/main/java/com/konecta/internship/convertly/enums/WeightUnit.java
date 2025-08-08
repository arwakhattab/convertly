package com.konecta.internship.convertly.enums;

import com.konecta.internship.convertly.exception.InvalidUnitException;

public enum WeightUnit implements Unit {
    GRAM("gram", "g"),
    KILOGRAM("kilogram", "Kg"),
    POUND("pound", "lb"),
    OUNCE("ounce", "oz");

    private final String value, symbol;

    WeightUnit(String value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public String getValue() {
        return this.value;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static WeightUnit fromString(String input) {
        for (WeightUnit u : values()) {
            if (u.value.equalsIgnoreCase(input)) {
                return u;
            }
        }
        throw new InvalidUnitException("Invalid unit: " + input + ", valid units are: gram, kilogram, pound, ounce");
    }
}
