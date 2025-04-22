package com.exercise.citycount.controller;

import com.exercise.citycount.service.CityCountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CityCountController {

    private final CityCountService cityCountService;

    public CityCountController(CityCountService cityCountService) {
        this.cityCountService = cityCountService;
    }

    @GetMapping("/citycount")
    public int getCityCount(@RequestParam("startsWith") String startsWith) {
        return cityCountService.countCitiesStartingWith(startsWith.toLowerCase());
    }
}