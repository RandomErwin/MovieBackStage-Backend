package org.web.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.web.dto.Result;
import org.web.entity.Movies;
import org.web.service.MovieService;

import java.sql.Date;
import java.sql.Time;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/createMovie")
    public Result createMovie(@RequestParam String title,
                              @RequestParam String rating,
                              @RequestParam String runtime,
                              @RequestParam String genre,
                              @RequestParam Date releaseDate,
                              @RequestParam String director,
                              @RequestParam String synopsis,
                              @RequestParam String language,
                              @RequestParam String trailer,
                              @RequestParam String postUrl){
        Movies movies = new Movies();
        movies.setTitle(title);
        movies.setRating(rating);
        movies.setRuntime(runtime);
        movies.setGenre(genre);
        movies.setReleaseDate(releaseDate);
        movies.setDirector(director);
        movies.setSynopsis(synopsis);
        movies.setLanguage(language);
        movies.setTrailer(trailer);
        movies.setPostUrl(postUrl);
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
