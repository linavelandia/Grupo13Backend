package com.app.MyMovies.controller;

import com.app.MyMovies.dto.ResponseDto;
import com.app.MyMovies.dto.ScoreDto;
import com.app.MyMovies.entities.Score;
import com.app.MyMovies.service.ScoreService;
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
    public Iterable<Score> get() {
        return service.get();
    }

    @GetMapping("/check/{movieId}")
    public Score check(@PathVariable("movieId") String movieId,@RequestHeader(value="authorization") String authorization) {
        return service.check(movieId,authorization);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto create(@RequestBody ScoreDto request,@RequestHeader(value="authorization") String authorization) {
        return service.create(request,authorization);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseDto update(@PathVariable("id") String id,@RequestBody Score request) {
        return service.update(request,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}
