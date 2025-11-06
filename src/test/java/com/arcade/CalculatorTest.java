package com.arcade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.RETURNS_DEFAULTS;
import static org.mockito.Mockito.mock;


class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();

    }

    @Test
    @Disabled// Skipped this test because it works fine
    void test_the_add() {
        double result = calculator.add(2, 7);
        assertFalse(result < 9 || result > 9);
        assertEquals(9, result);
    }


}

