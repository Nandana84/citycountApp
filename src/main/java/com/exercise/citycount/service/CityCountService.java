package com.exercise.citycount.service;

import com.exercise.citycount.entity.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CityCountService {

    private final RestTemplate restTemplate;

    private static final String API_URL =
        "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22";

    public int countCitiesStartingWith(String prefix) {
        WeatherResponse response = restTemplate.getForObject(API_URL, WeatherResponse.class);

        if (response == null || response.getList() == null) {
            return 0;
        }

        long count = response.getList().stream()
                .filter(city -> city.getName() != null && city.getName().toLowerCase().startsWith(prefix.toLowerCase()))
                .count();

        return (int) count;
    }
}