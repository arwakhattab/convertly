package com.konecta.internship.convertly.service;

import com.konecta.internship.convertly.enums.*;
import com.konecta.internship.convertly.exception.InvalidCategoryException;
import com.konecta.internship.convertly.model.ConversionRequest;
import com.konecta.internship.convertly.model.ConversionResponse;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {
    private final TemperatureService temperatureService;
    private final LengthService lengthService;
    private final WeightService weightService;
    private final TimeService timeService;

    public ConversionService(TemperatureService temperatureService, LengthService lengthService,
    WeightService weightService, TimeService timeService) {
        this.temperatureService = temperatureService;
        this.lengthService = lengthService;
        this.weightService = weightService;
        this.timeService = timeService;
    }

    public ConversionResponse convert(ConversionRequest request) {
        Category category = Category.fromString(request.getCategory());
        String fromUnit = request.getFromUnit(), toUnit = request.getToUnit();
        double input = request.getValue(), result = 0.0;
        String formula = "", status;
        switch (category) {
            case TEMPERATURE:
                TemperatureUnit fromTemp = TemperatureUnit.fromString(fromUnit);
                TemperatureUnit toTemp = TemperatureUnit.fromString(toUnit);
                result = temperatureService.convert(input, fromTemp, toTemp);
                formula = temperatureService.formula(input, result, fromTemp, toTemp);
                status = "success";
                break;
            case LENGTH:
                LengthUnit fromLen = LengthUnit.fromString(fromUnit);
                LengthUnit toLen = LengthUnit.fromString(toUnit);
                result = lengthService.convert(input, fromLen, toLen);
                formula = lengthService.formula(input, result, fromLen, toLen);
                status = "success";
                break;
            case WEIGHT:
                WeightUnit fromWei = WeightUnit.fromString(fromUnit);
                WeightUnit toWei = WeightUnit.fromString(toUnit);
                result = weightService.convert(input, fromWei, toWei);
                formula = weightService.formula(input, result, fromWei, toWei);
                status = "success";
                break;
            case TIME:
                TimeUnit fromTi = TimeUnit.fromString(fromUnit);
                TimeUnit toTi = TimeUnit.fromString(toUnit);
                result = timeService.convert(input, fromTi, toTi);
                formula = timeService.formula(input, result, fromTi, toTi);
                status = "success";
                break;
            default:
                throw new InvalidCategoryException();
        }
        return new ConversionResponse(input, result, formula, status);
    }

}
