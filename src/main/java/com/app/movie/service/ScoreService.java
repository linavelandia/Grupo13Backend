package com.app.movie.service;

import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Score;
import com.app.movie.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
public class ScoreService {

    private final String SCORE_REGISTERED="el puntaje ya estaba registrado mas de una vez";
    private final String SCORE_SUCCESS="el puntaje se registró correctamente";
    @Autowired
    ScoreRepository repository;

    public Iterable<Score> get(){
        Iterable<Score> response = repository.getAll();
        return response;
    }

    public ResponseDto create(Score request) {
        ResponseDto response = new ResponseDto();
        List<Score> scores = repository.getByMovie(request.getMovie());
        if(request.getScore().intValue()<0 || request.getScore().intValue()>5){
            response.status=false;
            response.message="la calificación no está dentro del rango esperados";
        }else{
            if(scores.size()>0){
                response.status=false;
                response.message=SCORE_REGISTERED;
            }
            else{
                repository.save(request);
                response.status=true;
                response.message=SCORE_SUCCESS;
                response.id= request.getId();
            }
        }
        return response;
    }
    public Score update(Score score){
        Score scoreToUpdate = new Score();

        Optional<Score> currentScore = repository.findById(score.getId());
        if(!currentScore.isEmpty()){
            scoreToUpdate = score;
            scoreToUpdate= repository.save(scoreToUpdate);
        }
        return scoreToUpdate;
    }

    public Boolean delete(String id){
        repository.deleteById(id);
        Boolean delete= true;
        return delete;
    }
}
