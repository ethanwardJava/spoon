package com.arcade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Builder

public class User {

    String name;
    String email;

    public User() {
        System.out.println("Constructor is called");
    }
}
