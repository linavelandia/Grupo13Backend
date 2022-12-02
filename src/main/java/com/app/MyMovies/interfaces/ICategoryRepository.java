package com.app.MyMovies.interfaces;

import com.app.MyMovies.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ICategoryRepository extends MongoRepository<Category, String> {
    
}
