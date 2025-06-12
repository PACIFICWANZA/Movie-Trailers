package dev.pacific.movies;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "users")
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String username;
    private String password;
    private Role role; // Role field to store USER/ADMIN

    // Constructor to initialize the user with username and password
    public User(String username, String password,Role role) {
        this.username = username;
        this.password = password;
        this.role = Role.USER; // Default role for new users
    }
}
