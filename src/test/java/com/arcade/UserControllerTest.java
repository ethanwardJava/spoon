package com.arcade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Test
    @DisplayName("Service get user should return mock user")
    void serviceGetUserById_ShouldReturn_John() {
        User user = User.builder().id(1L).name("John").email("babaYaga@gmail.com").role("ASSESSING").build();
        when(userService.findById(1L)).thenReturn(user);

        assertEquals(user.getName(), userController.findById(1L).getName());
    }
}