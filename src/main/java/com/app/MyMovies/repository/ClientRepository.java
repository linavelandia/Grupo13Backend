package com.app.MyMovies.repository;

import com.app.MyMovies.entities.Client;
import com.app.MyMovies.interfaces.IClientRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ClientRepository {
    
    @Autowired
    IClientRepository repository;
    
    public Iterable<Client> getAll(){
        return repository.findAll();
    }

    public List<Client> getByEmail(String email){
        return repository.getClientsByEmail(email);
    }

    public Optional<Client> findById(String id){
        Optional<Client> response= repository.findById(id);
        return response;
    }

    public Optional<Client> findByEmail(String email){
        Optional<Client> response= repository.findByEmail(email);
        return response;
    }
    
    public Boolean existsById(String id){
        return repository.existsById(id);
    }
    
    public void deleteById(String id){
        repository.deleteById(id);
    }
    
    public Client save(Client client){
        return repository.save(client);
    }
    
}
