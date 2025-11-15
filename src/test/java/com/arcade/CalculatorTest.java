package com.arcade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class CalculatorTest {

    Calculator calculator;


    @Mock
    Calculator calculatorMock;

    @BeforeEach
    void setUp() {
        System.out.println("===========setUp==========");
        calculator = new Calculator();
    }

    @Test
    @Disabled("Passed")
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

    @Disabled("Passed")
    @ParameterizedTest
    @CsvSource({
            "2,2,4",
            "0,0,0",
            "-100,100,0",
            "-25,-26,-51"
    })
    void mulAndSumShouldNotHaveEquality(int val1, int val2, int expected) {
        assertEquals(expected, calculator.sum(val1, val2));
    }

    @Test
    @Disabled("Passed")
    void whenGetName_returnMockName() {
        when(calculatorMock.getAuthor()).thenReturn("Pitter");

        String result = calculatorMock.getAuthor();

        assertEquals("Pitter", result);
        verify(calculatorMock).getAuthor();

    }



    @ParameterizedTest
    @ValueSource(strings = {"John" , "Jason" , "Hawk" , "Pitter" })
    void authorsNameShouldHaveLessThan10Characters(String name) {
        assertTrue(name.length() <= 10);
    }





}