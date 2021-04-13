package com.example.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParallelepipedCalculations {

    @JsonProperty
    private double AreaBot;
    @JsonProperty
    private double AreaSide;
    @JsonProperty
    private double AreaFront;
    @JsonProperty
    private double AreaFull;
    @JsonProperty
    private double Volume;
}
