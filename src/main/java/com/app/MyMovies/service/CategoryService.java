package com.app.MyMovies.service;

import com.app.MyMovies.dto.ResponseDto;
import com.app.MyMovies.entities.Category;
import com.app.MyMovies.entities.Movie;
import com.app.MyMovies.interfaces.ICategoryRepository;

import com.app.MyMovies.interfaces.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryService {

    private final String CATEGORY_REGISTERED="esta categoria ya esta registrada";
    private final String CATEGORY_SUCCESS="La categoria se registró correctamente";
    @Autowired
    ICategoryRepository repository;

    @Autowired
    IMovieRepository movieRepository;

    public Iterable<Category> get() {
        Iterable<Category> response;

        Iterable<Movie> movies = movieRepository.findAll();
        List<Category> categories = new ArrayList<>();
        for (Movie movie: movies) {
            if(movie.getCategories()!=null){
                for (Category cat:movie.getCategories()) {
                    if(!categories.stream().anyMatch(x->x.getName().equals(cat.getName()))){
                        Category currentCategory= new Category();
                        currentCategory.setName(cat.getName());
                        currentCategory.setDescription(cat.getDescription());
                        currentCategory.setAgeMinimum(cat.getAgeMinimum());
                        categories.add(currentCategory);
                    }
                }
            }
        }

        return categories;
    }

    public ResponseDto create(Category request) {

        Category newCategory = repository.save(request);

        ResponseDto responseDto = new ResponseDto();
        responseDto.status=true;
        responseDto.message=CATEGORY_REGISTERED;
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
