package com.app.MyMovies.interfaces;

import com.app.MyMovies.entities.Category;
import com.app.MyMovies.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ICategoryRepository extends MongoRepository<Category, String> {
    @Query(value= "{name : ?0}") // SQL Equivalent : SELECT * FROM Movie select * from Movie where name=?
    List<Category> getCategoriesByName(String name);

    List<Category> getByName(String name);
}
