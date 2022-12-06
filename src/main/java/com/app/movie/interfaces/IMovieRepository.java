package com.app.movie.interfaces;

import com.app.movie.entities.Movie;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface IMovieRepository extends MongoRepository<Movie, String> {
    @Query(value = "{name : ?0}")
    List<Movie> getMoviesByName(String name);
    
}
