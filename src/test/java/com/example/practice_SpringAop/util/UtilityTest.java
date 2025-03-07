package com.example.practice_SpringAop.util;

import com.example.practice_SpringAop.exceptions.AMoreThan10Exception;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    private Utility utility = null;
    private AvisCalculator avisCalculator = null;

    @BeforeEach
    public void setUp() {
        utility = new Utility();
        utility.setRateOfInterest(2);
        //   avisCalculator = new AvisCalculator();
        avisCalculator = Mockito.mock(AvisCalculator.class);
        utility.setAvisCalculator(avisCalculator);
    }

    @Test
    public void calculateTest() {
        Mockito.when(avisCalculator.avisCalculation(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())).thenReturn(5);
        //  Mockito.when(avisCalculator.avisCalculation(2,3)).thenReturn(5);
        Mockito.doNothing().when(avisCalculator).display(ArgumentMatchers.anyInt());
        try {
            int actual = utility.calculate(2, 3);
            int expected = 2;
            Assertions.assertEquals(expected, actual);
        } catch (AMoreThan10Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkEvenTest() {
        Assertions.assertTrue(utility.checkEven(45678));
        Assertions.assertFalse(utility.checkEven(4567));
    }

    @Test
    public void checkArithmeticExceptionTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            utility.setRateOfInterest(0);
            utility.calculate(5, 6);
        });
    }

    @Test
    public void checkAGreaterThan10() {
        Assertions.assertThrows(AMoreThan10Exception.class, () -> {
            utility.calculate(12, 3);
        });
    }
}