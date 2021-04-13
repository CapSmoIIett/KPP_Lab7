package com.example.app.controller;

import com.example.app.domain.Parallelepiped;
import com.example.app.domain.ParallelepipedCalculations;
import com.example.app.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParallelepipedParamsController {

    private CalculatorService calculatorService;

    @Autowired
    public ParallelepipedParamsController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public ParallelepipedCalculations getParams(@RequestParam ("h") double height,
                                                @RequestParam ("w") double width,
                                                @RequestParam ("d") double depth) {
        Parallelepiped parallelepiped = new Parallelepiped(height, width, depth);
        return calculatorService.calculate(parallelepiped);
    }
}
