package com.app.movie.service;


import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Score;
import com.app.movie.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

public class ScoreService {

    @Autowired
    ScoreRepository repository;

    public Iterable<Score> get(){
        Iterable<Score> response = repository.getAll();
        return response;
    }

    public ResponseDto create(Score request){
        ResponseDto response = new ResponseDto();
        if(request.getScore().intValue()<0 || request.getScore().intValue()>10){
            response.status=false;
            response.message="La calificacion enviada no esta dentro de los valores esperados";
        }else{
            repository.save(request);
            response.status=true;
            response.message="Calificación guardada correctamente";
            response.id= request.getId();
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
