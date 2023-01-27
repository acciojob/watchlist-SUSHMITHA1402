package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> direDb = new HashMap<>();
    HashMap<String, List<String>> direMovPair = new HashMap<>();

    public String addMovie(Movie movie){
        movieDb.put(movie.getName(), movie);
        return "Movie added Successfully";
    }

    public String addDirector(Director director){
        direDb.put(director.getName(), director);
        return "Director added Successfully";
    }

    public String addMovDirePair(String mov, String dire){
        if(!movieDb.containsKey(mov) || !direDb.containsKey(dire)){
            return "Data Not Found";
        }
        if(direMovPair.containsKey(dire)){
            List<String> temp = direMovPair.get(dire);
            temp.add(mov);
            direMovPair.put(dire, temp);
        }
        else{
            List<String> pairList = new ArrayList<>();
            pairList.add(mov);
            direMovPair.put(dire,pairList);
        }
        return "Movie Director Pair added Successfully";
    }

    public Movie getMovie(String movieName){
        return movieDb.get(movieName);
    }

    public Director getDirector(String direName){
        return direDb.get(direName);
    }

    public List<String> direMovies(String dire){
        return direMovPair.get(dire);
    }

    public List<String> allMovies(){
        List<String> movies = new ArrayList<>();
        for(Map.Entry<String,Movie> mov:movieDb.entrySet()){
            movies.add(mov.getValue().getName());
        }
        return  movies;
    }

    public String delDireMov(String director){
        if(!direDb.containsKey(director)){
            return null;
        }
        direDb.remove(director);
        List<String> direMov = direMovPair.get(director);
        for(String mov:direMov){
            movieDb.remove(mov);
        }
        direMovPair.remove(director);
        return director+" and Its movies Deleted Successfully";
    }
    public String delAllDireMov(){
        for(Map.Entry<String,Director> dire:direDb.entrySet()){
            delDireMov(dire.getKey());
        }
        return "All directors are Deleted";
    }
}
