package com.example.app.service;

import com.example.app.domain.Parallelepiped;
import com.example.app.domain.ParallelepipedCalculations;

public interface CalculatorService {
    ParallelepipedCalculations calculate(Parallelepiped parallelepiped)  throws InterruptedException ;
}
