package com.konecta.internship.convertly.enums;

import com.konecta.internship.convertly.exception.InvalidUnitException;

public enum TemperatureUnit implements Unit {
    CELSIUS("celsius", "°C"),
    FAHRENHEIT("fahrenheit", "°F"),
    KELVIN("kelvin", "K");

    private final String value, symbol;

    TemperatureUnit(String value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public String getValue() {
        return this.value;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static TemperatureUnit fromString(String input) {
        for (TemperatureUnit u : values()) {
            if (u.value.equalsIgnoreCase(input)) {
                return u;
            }
        }
        throw new InvalidUnitException("Invalid unit: " + input + ", valid units are: celsius, fahrenheit, kelvin");
    }
}
