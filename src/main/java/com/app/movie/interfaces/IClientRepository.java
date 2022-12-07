package com.app.movie.interfaces;

import com.app.movie.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IClientRepository extends MongoRepository<Client, String> {

    @Query(value= "{email : ?0}") // SQL Equivalent : SELECT * FROM Movie select * from Movie where name=?
    List<Client> getClientsByEmail(String email);

}
