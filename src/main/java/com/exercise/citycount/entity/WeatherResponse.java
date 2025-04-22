package com.exercise.citycount.entity;


import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {
    private String cod;
    private double calctime;
    private int cnt;
    private String name;
    private List<CityWeather> list;

    // Getters and Setters
}
