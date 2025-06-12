package dev.pacific.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Uses Repository class and talks to the DB and returns to the API//
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();

    }
    //Optional used to tell Java know it can return null if imdbId doesn't exist//
    public Optional<Movie>  singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);


    }
}
