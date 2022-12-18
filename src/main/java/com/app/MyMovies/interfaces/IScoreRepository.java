package com.app.MyMovies.interfaces;

import com.app.MyMovies.entities.Score;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface IScoreRepository extends MongoRepository<Score, String> {

    @Query(value= "{$and:[{'movie.id' : ?0},{'client.id':?1}]}") // SQL Equivalent : SELECT * FROM Movie select * from Movie where name=?
    List<Score> getScoreByMovieAndClient(String movieId,String clientId);

}
