package com.konecta.internship.convertly.service;

import com.konecta.internship.convertly.enums.TimeUnit;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    private double toSeconds(double value, TimeUnit unit) {
        switch (unit) {
            case SECOND: return value;
            case MINUTE: return value * 60;
            case HOUR:   return value * 3600;
            case DAY:    return value * 86400;
            default:     return value;
        }
    }

    private double fromSeconds(double seconds, TimeUnit unit) {
        switch (unit) {
            case SECOND: return seconds;
            case MINUTE: return seconds / 60;
            case HOUR:   return seconds / 3600;
            case DAY:    return seconds / 86400;
            default:     return seconds;
        }
    }

    public double convert(double input, TimeUnit from, TimeUnit to) {
        double inSeconds = toSeconds(input, from);
        return fromSeconds(inSeconds, to);
    }

    public String formula(double input, double result, TimeUnit from, TimeUnit to) {
        if (from == to) {
            return input + from.getSymbol() + " = " + result + to.getSymbol();
        }

        StringBuilder formula = new StringBuilder();
        formula.append(input).append(from.getSymbol());

        switch (from) {
            case SECOND:
                break;
            case MINUTE:
                formula.append(" × 60 = ").append(input * 60).append("s");
                break;
            case HOUR:
                formula.append(" × 3600 = ").append(input * 3600).append("s");
                break;
            case DAY:
                formula.append(" × 86400 = ").append(input * 86400).append("s");
                break;
        }

        if (to == TimeUnit.SECOND) return formula.toString();

        if (from != TimeUnit.SECOND) {
            formula.append(" → ");
            formula.append(result).append("s");
        }

        switch (to) {
            case MINUTE:
                formula.append(" / 60 = ").append(result);
                break;
            case HOUR:
                formula.append(" / 3600 = ").append(result);
                break;
            case DAY:
                formula.append(" / 86400 = ").append(result);
                break;
        }

        formula.append(to.getSymbol());
        return formula.toString();
    }
}
