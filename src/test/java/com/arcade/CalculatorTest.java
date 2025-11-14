package com.arcade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    Calculator calculator;


    Calculator calculatorMock = mock(Calculator.class);

    @BeforeEach
    void setUp() {
        System.out.println("===========setUp==========");
        calculator = new Calculator();
    }

    @Test
    public void sum() {
        assertAll(
                () -> assertEquals(3, calculator.sum(1, 2)),
                () -> assertEquals(125, calculator.sum(125, 0)),
                () -> assertThrows(ArithmeticException.class, () -> {
                    calculator.div(1, 0);
                }),
                () -> assertEquals(10, calculator.sub(10, 0))
        );
    }

    @Test
    void whenGetName_returnMockName() {
        when(calculatorMock.getAuthor()).thenReturn("Pitter");

        String result = calculatorMock.getAuthor();


        assertEquals("Pitter", result);
        verify(calculatorMock).getAuthor();

    }

}