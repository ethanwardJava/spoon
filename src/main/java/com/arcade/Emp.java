package com.arcade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Emp {
    private String firstName;
    private String lastName;
    private String email;

    public void greet() throws SQLException {
        System.out.println("Hello World");
    }
}

