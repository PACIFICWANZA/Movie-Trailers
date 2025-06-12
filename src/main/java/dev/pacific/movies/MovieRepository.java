package dev.pacific.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Talks to the DB//
//Repository has inbuilt methods for searching with id, exposing id in browser has security concerns abstraction//
//implement method(findMovieByImdbId)to search with imdb//
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdbId(String imdbId);
//query//


}
