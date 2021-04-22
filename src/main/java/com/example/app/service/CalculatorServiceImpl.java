package com.example.app.service;

import com.example.app.domain.Parallelepiped;
import com.example.app.domain.ParallelepipedCalculations;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@AllArgsConstructor
public class CalculatorServiceImpl implements CalculatorService{

    final private Logger logger = LoggerFactory.getLogger(CalculatorServiceImpl.class);
    private final AppealsCounter appealsCounter;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);


    public ParallelepipedCalculations calculate(Parallelepiped parallelepiped)  throws InterruptedException {

        executorService.submit(appealsCounter);
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
