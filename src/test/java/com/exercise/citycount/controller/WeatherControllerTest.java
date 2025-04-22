package com.exercise.citycount.controller;

import com.exercise.citycount.service.CityCountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CityCountService weatherService;

    @Test
    public void testGetCityCountByPrefix() throws Exception {
        // Mock the service method to return a count of 3 for prefix "z"
        Mockito.when(weatherService.countCitiesStartingWith(eq("z"))).thenReturn(3);

        // Perform the request and check the response status and content
        mockMvc.perform(get("/api/citycount?startsWith=z"))
                .andExpect(status().isOk())
                .andExpect(content().string("3"));
    }
}
