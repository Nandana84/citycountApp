package com.exercise.citycount.entity;

import lombok.Data;
import java.util.List;


@Data
public class CityWeather {
    private int id;
    private String name;
    private Coord coord;
    private Main main;
    private long dt;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private List<Weather> weather;

}
