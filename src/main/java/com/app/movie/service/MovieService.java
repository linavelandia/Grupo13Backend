package com.app.movie.service;
import com.app.movie.dto.ResponseDto;
import com.app.movie.entities.Movie;
import com.app.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class MovieService {

    private final String MOVIE_REGISTERED="La pelicula ya se ecnuentra registrada";
    private final String MOVIE_SUCCES="La pelicula se registro correctamente";
    @Autowired
    MovieRepository repository;
    public Iterable<Movie> get() {
        Iterable<Movie> response = repository.getAll();
        return response;
    }
    public ResponseDto create(Movie request) {
        ResponseDto response=new ResponseDto();
        List<Movie> movies = repository.getByName(request.getName());
        if(movies.size()>0){
            response.status=false;
            response.message=MOVIE_REGISTERED;
        }else{
            repository.save(request);
            response.status=true;
            response.message=MOVIE_SUCCES;
            response.id=request.getId();
        }
        return response;

    }
    public Movie update(Movie movie) {
        Movie movieToUpdate = new Movie();

        Optional<Movie> currentMovie = repository.findById(movie.getId());
        if (!currentMovie.isEmpty()) {
            movieToUpdate = movie;
            movieToUpdate=repository.save(movieToUpdate);
        }
        return movieToUpdate;
    }
    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}
