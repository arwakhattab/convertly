package com.konecta.internship.convertly.service;

import com.konecta.internship.convertly.enums.WeightUnit;
import org.springframework.stereotype.Service;

@Service
public class WeightService {

    private double toGrams(double value, WeightUnit unit) {
        switch (unit) {
            case GRAM:     return value;
            case KILOGRAM: return value * 1000;
            case POUND:    return value * 453.592;
            case OUNCE:    return value * 28.3495;
            default:       return value;
        }
    }

    private double fromGrams(double grams, WeightUnit unit) {
        switch (unit) {
            case GRAM:     return grams;
            case KILOGRAM: return grams / 1000;
            case POUND:    return grams / 453.592;
            case OUNCE:    return grams / 28.3495;
            default:       return grams;
        }
    }

    public double convert(double input, WeightUnit from, WeightUnit to) {
        double inGrams = toGrams(input, from);
        return fromGrams(inGrams, to);
    }

    public String formula(double input, double result, WeightUnit from, WeightUnit to) {
        if (from == to) {
            return input + from.getSymbol() + " = " + result + to.getSymbol();
        }

        StringBuilder formula = new StringBuilder();
        formula.append(input).append(from.getSymbol());

        switch (from) {
            case GRAM:
                break;
            case KILOGRAM:
                formula.append(" x 1000 = ").append(input * 1000).append("g");
                break;
            case POUND:
                formula.append(" x 453.592 = ").append(input * 453.592).append("g");
                break;
            case OUNCE:
                formula.append(" x 28.3495 = ").append(input * 28.3495).append("g");
                break;
        }

        if (to == WeightUnit.GRAM) return formula.toString();

        if (from != WeightUnit.GRAM) {
            formula.append(" → ");
            formula.append(result).append("g");
        }

        switch (to) {
            case KILOGRAM:
                formula.append(" / 1000 = ").append(result);
                break;
            case POUND:
                formula.append(" / 453.592 = ").append(result);
                break;
            case OUNCE:
                formula.append(" / 28.3495 = ").append(result);
                break;
        }

        formula.append(to.getSymbol());
        return formula.toString();
    }
}