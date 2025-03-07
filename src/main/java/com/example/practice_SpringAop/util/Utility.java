package com.example.practice_SpringAop.util;

import com.example.practice_SpringAop.exceptions.AMoreThan10Exception;

public class Utility {

    private Integer rateOfInterest;
    private AvisCalculator avisCalculator;

    public void setRateOfInterest(Integer rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public void setAvisCalculator(AvisCalculator avisCalculator) {
        this.avisCalculator = avisCalculator;
    }

    public int calculate(int a, int b) throws AMoreThan10Exception {
        if (a > 10) {
            throw new AMoreThan10Exception("a should not be more than 10");
        }
        System.out.println("below methods are taken from another class");
        avisCalculator.display(5);
        return avisCalculator.avisCalculation(a, b) / rateOfInterest;
        //  return (a + b) / rateOfInterest;
    }

    public boolean checkEven(int num) {
        return num % 2 == 0;
    }
}
