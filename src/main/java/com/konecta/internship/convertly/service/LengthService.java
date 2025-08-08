package com.konecta.internship.convertly.service;

import com.konecta.internship.convertly.enums.LengthUnit;
import org.springframework.stereotype.Service;

@Service
public class LengthService {
    private double toMeters(double value, LengthUnit unit) {
        switch (unit) {
            case METER:     return value;
            case KILOMETER: return value * 1000;
            case MILE:      return value * 1609.34;
            case INCH:      return value * 0.0254;
            case FOOT:      return value * 0.3048;
            default:        return value;
        }
    }

    private double fromMeters(double meters, LengthUnit unit) {
        switch (unit) {
            case METER:     return meters;
            case KILOMETER: return meters / 1000;
            case MILE:      return meters / 1609.34;
            case INCH:      return meters / 0.0254;
            case FOOT:      return meters / 0.3048;
            default:        return meters;
        }
    }

    public double convert(double input, LengthUnit from, LengthUnit to) {
        double inMeters = toMeters(input, from);
        return fromMeters(inMeters, to);
    }

    public String formula(double input, double result, LengthUnit from, LengthUnit to) {
        if (from == to) {
            return input + from.getSymbol() + " = " + result + to.getSymbol();
        }

        StringBuilder formula = new StringBuilder();
        formula.append(input).append(from.getSymbol());

        switch (from) {
            case METER:
                break;
            case KILOMETER:
                formula.append(" x 1000 = ").append(input * 1000).append("m");
                break;
            case MILE:
                formula.append(" x 1609.34 = ").append(input * 1609.34).append("m");
                break;
            case INCH:
                formula.append(" x 0.0254 = ").append(input * 0.0254).append("m");
                break;
            case FOOT:
                formula.append(" x 0.3048 = ").append(input * 0.3048).append("m");
                break;
        }
        if (to == LengthUnit.METER) return formula.toString();

        if (from != LengthUnit.METER) {
            formula.append(" → ");
            formula.append(result).append("m");
        }

        switch (to) {
            case KILOMETER:
                formula.append(" / 1000 = ").append(result);
                break;
            case MILE:
                formula.append(" / 1609.34 = ").append(result);
                break;
            case INCH:
                formula.append(" / 0.0254 = ").append(result);
                break;
            case FOOT:
                formula.append(" / 0.3048 = ").append(result);
                break;
        }
        formula.append(to.getSymbol());
        return formula.toString();
    }
}
