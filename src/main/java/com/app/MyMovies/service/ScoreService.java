package com.app.MyMovies.service;

import com.app.MyMovies.dto.ResponseDto;
import com.app.MyMovies.entities.Score;
import com.app.MyMovies.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ScoreService {

    @Autowired
    ScoreRepository repository;

    public Iterable<Score> get() {
        Iterable<Score> response = repository.getAll();
        return response;
    }

    public ResponseDto create(Score request) {
        ResponseDto response = new ResponseDto();
        if(request.getScore().intValue()<0 || request.getScore().intValue()>10){
            response.status=false;
            response.message="La calificación enviada no está dentro de los valores esperados";
        }else{
            repository.save(request);
            response.status=true;
            response.message="Calificación guardada correctamente";
            response.id= request.getId();
        }
        return response;
    }

    public Score update(Score score) {
        Score scoreToUpdate = new Score();

        Optional<Score> currentScore = repository.findById(score.getId());
        if (!currentScore.isEmpty()) {
            scoreToUpdate = score;
            scoreToUpdate=repository.save(scoreToUpdate);
        }
        return scoreToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}
