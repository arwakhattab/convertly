package com.konecta.internship.convertly.service;

import com.konecta.internship.convertly.enums.TemperatureUnit;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    public double convert(double input, TemperatureUnit from, TemperatureUnit to) {
        if (from == to) return input;

        switch (from) {
            case CELSIUS:
                if (to == TemperatureUnit.FAHRENHEIT) {
                    return input * 9 / 5 + 32;
                } else if (to == TemperatureUnit.KELVIN) {
                    return input + 273.15;
                }
                break;

            case FAHRENHEIT:
                if (to == TemperatureUnit.CELSIUS) {
                    return (input - 32) * 5 / 9;
                } else if (to == TemperatureUnit.KELVIN) {
                    return (input - 32) * 5 / 9 + 273.15;
                }
                break;

            case KELVIN:
                if (to == TemperatureUnit.CELSIUS) {
                    return input - 273.15;
                } else if (to == TemperatureUnit.FAHRENHEIT) {
                    return (input - 273.15) * 9 / 5 + 32;
                }
                break;
        }

        return input;
    }

    public String formula(double input, double result, TemperatureUnit from, TemperatureUnit to) {
        if (from == to) {
            return input + from.getSymbol() + " = " + result + to.getSymbol();
        }

        StringBuilder formula = new StringBuilder();

        switch (from) {
            case CELSIUS:
                if (to == TemperatureUnit.FAHRENHEIT) {
                    formula.append("(").append(input).append(from.getSymbol())
                            .append(" × 9/5) + 32 = ").append(result).append(to.getSymbol());
                } else if (to == TemperatureUnit.KELVIN) {
                    formula.append(input).append(from.getSymbol())
                            .append(" + 273.15 = ").append(result).append(to.getSymbol());
                }
                break;

            case FAHRENHEIT:
                if (to == TemperatureUnit.CELSIUS) {
                    formula.append("(").append(input).append(from.getSymbol())
                            .append(" - 32) × 5/9 = ").append(result).append(to.getSymbol());
                } else if (to == TemperatureUnit.KELVIN) {
                    formula.append("(").append(input).append(from.getSymbol())
                            .append(" - 32) × 5/9 + 273.15 = ").append(result).append(to.getSymbol());
                }
                break;

            case KELVIN:
                if (to == TemperatureUnit.CELSIUS) {
                    formula.append(input).append(from.getSymbol())
                            .append(" - 273.15 = ").append(result).append(to.getSymbol());
                } else if (to == TemperatureUnit.FAHRENHEIT) {
                    formula.append("(").append(input).append(from.getSymbol())
                            .append(" - 273.15) × 9/5 + 32 = ").append(result).append(to.getSymbol());
                }
                break;
        }

        return formula.toString();
    }
}
