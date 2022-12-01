package com.app.movie.interfaces;



import com.app.movie.entities.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IScoreRepository extends MongoRepository<Score, String> {

}
