package dev.pacific.movies;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Gets the list of movies and uses Service class to get All movies from the db and giving it back to API layer//
//Does not know what's happening in Service class//
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")

public class MovieController {

    @Autowired
    private MovieService movieService;

    //Calls the getAllMovies() movies method//
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);

    }
//attempts to get a single movie//
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>>  getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);



    }


}
