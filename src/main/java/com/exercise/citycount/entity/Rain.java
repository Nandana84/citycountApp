package com.exercise.citycount.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Rain {
    @JsonProperty("3h")
    private double volume3h;

    // Getter and Setter
}
