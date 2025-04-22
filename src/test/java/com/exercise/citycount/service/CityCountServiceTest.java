package com.exercise.citycount.service;


import com.exercise.citycount.entity.CityWeather;
import com.exercise.citycount.entity.WeatherResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class CityCountServiceTest {
    private RestTemplate restTemplate;
    private CityCountService cityCountService;

    @BeforeEach
    public void setup() {
        restTemplate = Mockito.mock(RestTemplate.class);
        cityCountService = new CityCountService(restTemplate);

    }

    @Test
    public void testCountCitiesWithPrefix() {
        WeatherResponse mockResponse = new WeatherResponse();
        CityWeather city1 = new CityWeather();
        city1.setName("Yafran");
        CityWeather city2 = new CityWeather();
        city2.setName("Zuwarah");
        mockResponse.setList(Arrays.asList(city1, city2));
        when(restTemplate.getForObject(anyString(), eq(WeatherResponse.class)))
                .thenReturn(mockResponse);
        int count = cityCountService.countCitiesStartingWith("y");
        assertEquals(1, count);
    }

    @Test
    public void testCountCitiesWithPrefix_cityNotPresent_returnsDefaultValueAs0() {
        WeatherResponse mockResponse = new WeatherResponse();
        CityWeather city1 = new CityWeather();
        city1.setName("Yafran");

        mockResponse.setList(Arrays.asList(city1));
        when(restTemplate.getForObject(anyString(), eq(WeatherResponse.class)))
                .thenReturn(mockResponse);
        int count = cityCountService.countCitiesStartingWith("z");
        assertEquals(0, count);
    }
}