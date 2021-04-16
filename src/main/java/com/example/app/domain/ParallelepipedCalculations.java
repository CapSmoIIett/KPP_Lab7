package com.example.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParallelepipedCalculations {
    private double areaBot;
    private double areaSide;
    private double areaFront;
    private double areaFull;
    private double volume;
}
