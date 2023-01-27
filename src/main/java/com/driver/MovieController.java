package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody() Movie movie){
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED) ;
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody() Director director){
        String response = movieService.addDirector(director);
        return new ResponseEntity<>(response, HttpStatus.CREATED) ;
    }

    @PostMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("mov") String movie, @RequestParam("dir") String director){
        String response = movieService.addMovDirePair(movie,director);
        return new ResponseEntity<>(response, HttpStatus.CREATED) ;
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String movie){
        return new ResponseEntity<>(movieService.getMovie(movie) , HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName (@PathVariable("name") String director){
        return new ResponseEntity<>(movieService.getDirector(director) , HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String director){
        return new ResponseEntity<>(movieService.direMovies(director) , HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("dire") String director){
        String response = movieService.delDireMov(director);
        if(response==null) return new ResponseEntity<>("Invalid request",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        return new ResponseEntity<>(movieService.delAllDireMov(), HttpStatus.FOUND);
    }
}
