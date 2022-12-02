package com.app.MyMovies.interfaces;

import com.app.MyMovies.entities.Score;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IScoreRepository extends MongoRepository<Score, String> {
    
}
