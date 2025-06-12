package dev.pacific.movies;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role; // Should be either USER or ADMIN
}
