package com.konecta.internship.convertly.enums;

import com.konecta.internship.convertly.exception.InvalidCategoryException;

public enum Category {
    TEMPERATURE("temperature"),
    LENGTH("length"),
    WEIGHT("weight"),
    TIME("time");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Category fromString(String input) {
        for (Category c : values()) {
            if (c.value.equalsIgnoreCase(input)) {
                return c;
            }
        }
        throw new InvalidCategoryException("Invalid category: " + input);
    }
}
