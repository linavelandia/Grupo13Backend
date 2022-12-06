package com.app.movie.interfaces;

import com.app.movie.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IClientRepository extends MongoRepository<Client, String> {
    
}
