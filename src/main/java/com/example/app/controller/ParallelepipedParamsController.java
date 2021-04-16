package com.example.app.controller;

import com.example.app.domain.Parallelepiped;
import com.example.app.domain.ParallelepipedCalculations;
import com.example.app.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ParallelepipedParamsController {

    final private CalculatorService calculatorService;

    @GetMapping("/")
    public ParallelepipedCalculations getParams(@RequestParam ("h") double height,
                                                @RequestParam ("w") double width,
                                                @RequestParam ("d") double depth) {
        Parallelepiped parallelepiped = new Parallelepiped(height, width, depth);
        return calculatorService.calculate(parallelepiped);
    }
}
