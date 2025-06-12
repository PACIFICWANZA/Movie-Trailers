package dev.pacific.movies;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Find user by username
    User findByUsername(String username);

    // Check if a user already exists by username
    boolean existsByUsername(String username);
}
