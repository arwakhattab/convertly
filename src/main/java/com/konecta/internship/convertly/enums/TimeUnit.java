package com.konecta.internship.convertly.enums;

import com.konecta.internship.convertly.exception.InvalidUnitException;

public enum TimeUnit implements Unit {
    SECOND("second", "s"),
    MINUTE("minute", "m"),
    HOUR("hour", "h"),
    DAY("day", "d");

    private final String value, symbol;

    TimeUnit(String value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public String getValue() {
        return this.value;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static TimeUnit fromString(String input) {
        for (TimeUnit u : values()) {
            if (u.value.equalsIgnoreCase(input)) {
                return u;
            }
        }
        throw new InvalidUnitException("Invalid unit: " + input + ", valid units are: second, minute, hour, day");
    }
}
