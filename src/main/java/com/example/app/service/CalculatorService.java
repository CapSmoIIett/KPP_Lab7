package com.example.app.service;

import com.example.app.domain.Parallelepiped;
import com.example.app.domain.ParallelepipedCalculations;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public ParallelepipedCalculations calculate(Parallelepiped parallelepiped) {
        return new ParallelepipedCalculations(parallelepiped.getWidth() * parallelepiped.getDepth(),
                                              parallelepiped.getHeight() * parallelepiped.getDepth(),
                                              parallelepiped.getHeight() * parallelepiped.getWidth(),
                                              2 * (parallelepiped.getDepth()) + parallelepiped.getHeight()
                                                + parallelepiped.getWidth(),
                                              parallelepiped.getDepth() * parallelepiped.getHeight()
                                                * parallelepiped.getWidth());
    }
}
