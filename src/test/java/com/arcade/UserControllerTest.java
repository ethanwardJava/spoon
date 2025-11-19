package com.arcade;

import com.arcade.controller.UserController;
import com.arcade.entity.User;
import com.arcade.repository.UserRepository;
import com.arcade.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {


    @Mock
    UserRepository userRepository;

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;





    @Test
    @DisplayName("Service get user should return mock user")
    void serviceGetUserById_ShouldReturn_John() {
        User john = User.builder().id(1L).name("John").email("babaYaga@gmail.com").role("ASSESSING").build();
        when(userService.findById(1L)).thenReturn(john);
        assertEquals(john.getName(), userController.findById(1L).getName());
    }

    @Test
    void getUserByName_ShouldReturnUsers() {
        User john = User.builder().id(1L).name("John").build();
        User johnny = User.builder().id(2L).name("Johnny").build();

        List<User> expectedUsers = List.of(john, johnny);

        when(userService.findByName("Johnny")).thenReturn(expectedUsers);

        List<User> result = userController.findByName("Johnny");

        assertAll(
                () -> assertEquals(2, result.size()),
                () -> assertTrue(result.stream().anyMatch(u -> u.getName().equals("John"))),
                () -> assertTrue(result.stream().anyMatch(u -> u.getName().equals("Johnny")))
        );

        verify(userService).findByName("Johnny");
    }


}