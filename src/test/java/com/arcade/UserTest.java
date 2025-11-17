package com.arcade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserTest {

    User user;

    User userMock = mock(User.class, "userMock");

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void chackUser() {
        when(userMock.getName()).thenReturn("John");
        assertEquals("John", userMock.getName());
    }

    @Test
    void chackUser2() {
        when(userMock.getName()).thenReturn("Jack");
        assertEquals("Jack", userMock.getName());
    }

}