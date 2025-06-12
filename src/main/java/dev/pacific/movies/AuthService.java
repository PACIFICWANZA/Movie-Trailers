package dev.pacific.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Method to authenticate user (login)
    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    // Method to register a new user, accepting a role parameter
    public User registerUser(String username, String password, Role role) {
        // Check if the username already exists
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already taken");
        }

        // Encrypt the password
        String encryptedPassword = passwordEncoder.encode(password);

        // Create a new user object with the username, encrypted password, and provided role
        User newUser = new User(username, encryptedPassword, role);

        // Save the new user to the database
        return userRepository.save(newUser);
    }
}
