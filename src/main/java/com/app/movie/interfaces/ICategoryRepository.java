package com.app.movie.interfaces;

import com.app.movie.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ICategoryRepository extends MongoRepository<Category, String> {
    
}
