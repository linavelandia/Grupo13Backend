package com.app.MyMovies.interfaces;

import com.app.MyMovies.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface IClientRepository extends MongoRepository<Client, String> {

    @Query(value= "{email : ?0}") // SQL Equivalent : SELECT * FROM Movie select * from Movie where name=?
    List<Client> getClientsByEmail(String email);
    @Query(value= "{email : ?0}")
    Optional<Client> findByEmail(String email);
}
