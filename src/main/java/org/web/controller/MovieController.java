package org.web.controller;
import org.springframework.web.bind.annotation.*;
import org.web.dto.Result;
import org.web.entity.Movies;
import org.web.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/createMovie")
    public Result createMovie(@RequestBody Movies movies){
        return movieService.createMovie( movies);
    }

    @PutMapping("/updateMovie")
    public Result updateMovie(@RequestBody Movies movie){
        return movieService.updateMovie(movie);
    }

    @DeleteMapping("/deleteMovie")
    public Result deleteMovie(@PathVariable Integer id){
        return movieService.deleteMovie(id);
    }

    @GetMapping("/getMovie/{id}")
    public Result getMovie(@PathVariable Integer id){
        return movieService.getMovie(id);
    }
}
