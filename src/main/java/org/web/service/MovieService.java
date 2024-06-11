package org.web.service;

import org.springframework.stereotype.Service;
import org.web.dao.MovieDao;
import org.web.dto.Result;
import org.web.entity.Movies;

import java.util.Optional;

@Service
public class MovieService {
    private MovieDao movieDao;

    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public Result createMovie(Movies movies){
        Movies movie = movieDao.save(movies);
        return new Result(200, movie);
    }

    public Result updateMovie(Movies movies){
        Movies movie = movieDao.save(movies);
        return new Result(200, movie);
    }

    public Result deleteMovie(Integer id){
        movieDao.deleteById(id);
        return new Result(200, "success");
    }

    public Result getMovie(Integer id){
        Optional<Movies> moviesOptional = movieDao.findById(id);
        if(moviesOptional.isPresent()){
            return  new Result(200, moviesOptional.get());
        }else{
            return new Result(999, "No data");
        }

    }
}
