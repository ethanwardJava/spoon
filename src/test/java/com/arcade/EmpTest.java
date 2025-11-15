package com.arcade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmpTest {
    @Mock
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
}