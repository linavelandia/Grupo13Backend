package com.app.movie.controller;
import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Category;
import com.app.movie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    CategoryService service;

    @GetMapping("")
    public Iterable<Category> get() {
        Iterable<Category> response = service.get();
        return response;
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseDto> create(@RequestBody Category request){
        ResponseDto responseDto = service.create(request);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto,HttpStatus.CONFLICT);
        if(responseDto.status.booleanValue()==true){
            response = new ResponseEntity<>(responseDto,HttpStatus.CREATED);
        }
    return response;
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Category update(@RequestBody Category request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}
