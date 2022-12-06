package com.app.movie.controller;


import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Score;
import com.app.movie.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/score")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    ScoreService service;

    @GetMapping("")
    public Iterable<Score> get(){
        return service.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto create(@RequestBody Score request){
        if(request.getScore().intValue()>4){
            System.out.println("mayor a 4");
        }
        return service.create(request);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Score update(@RequestBody Score request){
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}
