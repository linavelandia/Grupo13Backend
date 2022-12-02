package com.app.MyMovies.interfaces;

import com.app.MyMovies.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface IMovieRepository extends MongoRepository<Movie, String> {
    @Query(value= "{name : ?0}") // SQL Equivalent : SELECT * FROM Movie select * from Movie where name=?
    List<Movie> getMoviesByName(String name);
}
