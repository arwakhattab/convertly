package com.konecta.internship.convertly.enums;

import com.konecta.internship.convertly.exception.InvalidUnitException;

public enum LengthUnit implements Unit {
    METER("meter","m"),
    KILOMETER("kilometer", "Km"),
    MILE("mile", "mi"),
    INCH("inch", "in"),
    FOOT("foot", "ft");

    private final String value, symbol;

    LengthUnit(String value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public String getValue() {
        return this.value;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static LengthUnit fromString(String input) {
        for (LengthUnit u : values()) {
            if (u.value.equalsIgnoreCase(input)) {
                return u;
            }
        }
        throw new InvalidUnitException("Invalid unit: " + input + ", valid units are: meter, kilometer, mile, inch, foot");
    }
}
