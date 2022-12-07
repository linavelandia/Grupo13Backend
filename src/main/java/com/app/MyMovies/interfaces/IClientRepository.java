package com.app.MyMovies.interfaces;

import com.app.MyMovies.entities.Client;
import com.app.MyMovies.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface IClientRepository extends MongoRepository<Client, String> {
    @Query(value= "{name : ?0}") // SQL Equivalent : SELECT * FROM Movie select * from Movie where name=?
    List<Client> getClientsByName(String name);
    
}
