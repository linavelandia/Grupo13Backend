package com.app.MyMovies.service;

import com.app.MyMovies.dto.ResponseDto;
import com.app.MyMovies.entities.Category;
import com.app.MyMovies.entities.Movie;
import com.app.MyMovies.interfaces.ICategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {

    private final String CATEGORY_REGISTERED="esta categoria ya esta registrada";
    private final String CATEGORY_SUCCESS="La categoria se registró correctamente";
    @Autowired
    ICategoryRepository repository;

    public Iterable<Category> get() {
        Iterable<Category> response = repository.findAll();
        return response;
    }

    public ResponseDto create(Category request) {
        ResponseDto response = new ResponseDto();
        List<Category> categories = repository.getByName(request.getName());
        if(categories.size()>0){
            response.status=false;
            response.message=CATEGORY_REGISTERED;
        }else{
            repository.save(request);
            response.status=true;
            response.message=CATEGORY_SUCCESS;
            response.id= request.getId();
        }
        return response;
    }

    public Category update(Category category) {
        Category categoryToUpdate = new Category();
        if (repository.existsById(category.getId())) {
            categoryToUpdate = category;
            repository.save(categoryToUpdate);
        }
        return categoryToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}
