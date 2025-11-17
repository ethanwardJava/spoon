package com.arcade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserTest {


    @Mock
    User user;

    @BeforeEach
    void setUp() {
        when(user.getName()).thenReturn("Alex");
        when(user.getEmail()).thenReturn("alexDrugDealer67@gmail.com");
    }

    @Test
    void nameShouldBeAlex() {
        assertAll(
                () -> assertEquals("Alex".toLowerCase(), user.getName().toLowerCase()),
                () -> assertEquals("alexDrugDealer67@gmail.com".toLowerCase(), user.getEmail().toLowerCase())
        );
    }


}