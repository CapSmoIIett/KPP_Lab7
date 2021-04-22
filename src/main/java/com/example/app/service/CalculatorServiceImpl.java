package com.example.app.service;

import com.example.app.domain.Parallelepiped;
import com.example.app.domain.ParallelepipedCalculations;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    final private Logger logger = LoggerFactory.getLogger(CalculatorServiceImpl.class);

    public ParallelepipedCalculations calculate(Parallelepiped parallelepiped) {

        logger.info("Successful calculations");

        return new ParallelepipedCalculations(parallelepiped.getWidth() * parallelepiped.getDepth(),
                                              parallelepiped.getHeight() * parallelepiped.getDepth(),
                                              parallelepiped.getHeight() * parallelepiped.getWidth(),
                                              2 * (parallelepiped.getDepth()) + parallelepiped.getHeight()
                                                + parallelepiped.getWidth(),
                                              parallelepiped.getDepth() * parallelepiped.getHeight()
                                                * parallelepiped.getWidth());
    }
}