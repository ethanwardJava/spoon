package com.arcade;

import com.arcade.controller.UserController;
import com.arcade.entity.User;
import com.arcade.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
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
        User john = User.builder().id(1L).name("John").email("babaYaga@gmail.com").role("ASSESSING").build();
        when(userService.findById(1L)).thenReturn(john);
        assertEquals(john.getName(), userController.findById(1L).getName());
    }

    @Test
    @DisplayName("find users based on name")
    void getUserByName_ShouldReturnUsers() {
        User john = User.builder().id(1L).name("John").build();
        User johnny = User.builder().id(2L).name("Johnny").build();

        List<User> expectedUsers = List.of(john, johnny);

        when(userService.findByName("Johnny")).thenReturn(expectedUsers);

        List<User> result = userController.findByName("Johnny");

        assertAll(
                () -> assertNotNull(result, "Null found"),
                () -> assertEquals(2, result.size(), "Wrong result size"),
                () -> assertTrue(result.stream().anyMatch(u -> u.getName().equals("John")), "No Match found"),
                () -> assertTrue(result.stream().anyMatch(u -> u.getName().equals("Johnny")), "No Match found")
        );

        verify(userService).findByName("Johnny");
    }

    @Test
    void getUserBYIdWithAssertThat() {

        User lola = User.builder().id(1L).name("lola").email("lolcaWhoDoesntsellMeat75@gmail.com").role("Butcher").build();
        when(userService.findById(1L)).thenReturn(lola);
        User result = userController.findById(1L);

        assertThat(result.getName())
                .isNotBlank()
                .isNotNull()
                .isNotEqualTo("john")
                .isEqualTo("lola")
                .contains("lo");
        verify(userService).findById(anyLong());

    }

    @Test
    void getUserByIdWithBDD() {
        User lola = User.builder().id(1L).name("lola").email("lolcaWhoDoesntsellMeat75@gmail.com").role("Butcher").build();
        given(userService.findById(1L)).willReturn(lola);
        User result = userController.findById(1L);
        assertThat(result.getName())
                .isNotBlank().isEqualTo("lola");
        verify(userService).findById(anyLong());
    }
}