package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareCalculatorTest {

    private SquareCalculator calculator = new SquareCalculator();

    @Test
    public void testPositive() {
        assertEquals(25, calculator.calculateSquare(5));
        assertThat(calculator.calculateSquare(5)).isEqualTo(25);
    }

}
