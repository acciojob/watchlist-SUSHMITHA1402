package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director){
        return movieRepository.addDirector(director);
    }

    public String addMovDirePair(String mov, String dire){
        return movieRepository.addMovDirePair(mov,dire);
    }

    public Movie getMovie(String movieName){
        return movieRepository.getMovie(movieName);
    }

    public Director getDirector(String direName){
        return movieRepository.getDirector(direName);
    }

    public List<String> direMovies(String dire){
        return movieRepository.direMovies(dire);
    }

    public List<String> allMovies(){
        return movieRepository.allMovies();
    }

    public String delDireMov(String director){
        return movieRepository.delDireMov(director);
    }
    public String delAllDireMov(){
        return movieRepository.delAllDireMov();
    }

}
