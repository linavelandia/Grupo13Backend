package com.app.MyMovies.interfaces;

import com.app.MyMovies.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IClientRepository extends MongoRepository<Client, String> {
    
}
