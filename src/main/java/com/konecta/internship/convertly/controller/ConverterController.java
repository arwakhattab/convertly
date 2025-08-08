package com.konecta.internship.convertly.controller;

import com.konecta.internship.convertly.enums.*;
import com.konecta.internship.convertly.model.ConversionRequest;
import com.konecta.internship.convertly.model.ConversionResponse;
import com.konecta.internship.convertly.service.ConversionService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class ConverterController {

    private final ConversionService conversionService;

    public ConverterController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @PostMapping("/convert")
    public ConversionResponse convert(@Valid @RequestBody ConversionRequest request) {
        return conversionService.convert(request);
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return Arrays.stream(Category.values())
                .map(c -> c.name().toLowerCase()) // or .map(String::toLowerCase)
                .toList();
    }

    @GetMapping("/units")
    public List<String> getUnits(@RequestParam String category) {
        switch (category) {
            case "temperature":
                return Arrays.stream(TemperatureUnit.values())
                        .map(u -> u.name().toLowerCase()) // or .map(String::toLowerCase)
                        .toList();
            case "length":
                return Arrays.stream(LengthUnit.values())
                        .map(u -> u.name().toLowerCase()) // or .map(String::toLowerCase)
                        .toList();
            case "weight":
                return Arrays.stream(WeightUnit.values())
                        .map(u -> u.name().toLowerCase()) // or .map(String::toLowerCase)
                        .toList();
            case "time":
                return Arrays.stream(TimeUnit.values())
                        .map(u -> u.name().toLowerCase()) // or .map(String::toLowerCase)
                        .toList();
            default: return null;
        }
    }

    @GetMapping("/sample-payload")
    public ConversionRequest getSample() {
        return new ConversionRequest("temperature", "celsius", "kelvin", 30);
    }

    @GetMapping("/health")
    public Map<String, String> healthCheck() {
        return Map.of("status", "Unit Converter API is up and running");
    }
}
