package com.app.movie.service;

import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Category;
import com.app.movie.interfaces.ICategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    ICategoryRepository repository;

    public Iterable<Category> get() {
        Iterable<Category> response = repository.findAll();
        return response;
    }

    public ResponseDto create(Category request) {

        Category newCategory = repository.save(request);

        ResponseDto responseDto = new ResponseDto();
        responseDto.status=true;
        responseDto.message="Categoría creada correctamente";
        responseDto.id= newCategory.getId();
        return responseDto;

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
