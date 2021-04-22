package com.example.app.controller;

import com.example.app.domain.Parallelepiped;
import com.example.app.domain.ParallelepipedCalculations;
import com.example.app.service.CalculatorServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;

@Validated
@RestController
@AllArgsConstructor
public class ParallelepipedParamsController {

    final private CalculatorServiceImpl calculatorService;
    final private Logger logger = LoggerFactory.getLogger(ParallelepipedParamsController.class);

    @GetMapping("/")
    public ParallelepipedCalculations getParams(@RequestParam ("h") @Min (value = 1  , message = "Height must be more 1")
                                                double height,
                                                @RequestParam ("w") @Min (value = 1  , message = "Width must be more 1")
                                                double width,
                                                @RequestParam ("d") @Min (value = 1  , message = "Depth must be more 1")
                                                double depth) throws ConstraintViolationException {
        Parallelepiped parallelepiped = new Parallelepiped(height, width, depth);
        return calculatorService.calculate(parallelepiped);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        logger.warn(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
