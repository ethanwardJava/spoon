package com.arcade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmpTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private Emp emp;

    @Test
    void getFirstName() {
        MockSettings settings;

        // default Java values if not stubbed
        settings = withSettings().defaultAnswer(RETURNS_DEFAULTS);
        Emp empMock = mock(Emp.class, settings);

        when(emp.getLastName()).thenReturn("ShirFarhad");
        System.out.println(emp.getFirstName());
        assertEquals("ShirFarhad", emp.getLastName());
        // ==========================================================

        settings = withSettings().defaultAnswer(RETURNS_SMART_NULLS);
        Emp empMock2 = mock(Emp.class, settings);
    }


    @Test
    void math() {
        Calculator calculator = spy(Calculator.class);
        int realVal = calculator.sum(7, 3);
        assertThat(realVal).isEqualTo(10).isGreaterThan(9).isLessThan(11);
    }

    @Test
    void throwExceptionIsVoidIsCalled() throws SQLException {
        doThrow(new SQLException()).when(emp).greet();
        assertThrows(SQLException.class, () -> emp.greet());
    }
}