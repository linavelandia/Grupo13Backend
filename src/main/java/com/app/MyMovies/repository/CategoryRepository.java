package com.app.MyMovies.repository;

import com.app.MyMovies.entities.Category;
import com.app.MyMovies.interfaces.ICategoryRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CategoryRepository {
    
    @Autowired
    ICategoryRepository repository;
    
    public Iterable<Category> getAll(){
        return repository.findAll();
    }
    
    public Optional<Category> findById(String id){
        Optional<Category> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(String id){
        return repository.existsById(id);
    }
    
    public void deleteById(String id){
        repository.deleteById(id);
    }
    
    public Category save(Category category){
        return repository.save(category);
    }
    
}
