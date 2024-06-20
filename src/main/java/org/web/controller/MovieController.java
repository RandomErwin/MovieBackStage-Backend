package org.web.controller;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.web.dto.Result;
import org.web.entity.Movies;
import org.web.service.MovieService;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // 當前端發送FormData時，後端需要有與之對應的參數@RequestParam
    // CORS藉由一堆的response header => 告訴瀏覽器有哪些東西前端具有存取權
    // no-cors => 後端增加 header: Access-Control-Allow-Origin: *
    @PostMapping("/createMovie")
    public Result createMovie(@RequestParam String title,
                              @RequestParam String titleEnglish,
                              @RequestParam String rating,
                              @RequestParam String runtime,
                              @RequestParam String genre,
                              @RequestParam LocalDate releaseDate,
                              @RequestParam String director,
                              @RequestParam String synopsis,
                              @RequestParam String language,
                              @RequestParam String trailer,
                              @RequestParam String poster,
                              @RequestParam Boolean isOutTheater){
        Movies movies = new Movies();
        movies.setTitle(title);
        movies.setTitleEnglish(titleEnglish);
        movies.setRating(rating);
        movies.setRuntime(runtime);
        movies.setGenre(genre);
        movies.setReleaseDate(releaseDate);
        movies.setDirector(director);
        movies.setSynopsis(synopsis);
        movies.setLanguage(language);
        movies.setTrailer(trailer);
        movies.setPoster(poster);
        movies.setOutTheater(isOutTheater);
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

    @GetMapping("/getMovie/isComing")
    public Result getMoviesByIsComing(){
        return movieService.getMoviesByIsComing();
    }

    @GetMapping("getMovie/isPlaying")
    public Result getMoviesByIsPlaying(){
        return movieService.getMoviesByIsPlaying();
    }

    @PutMapping("updateMovie/{id}")
    public Result updateMovieById(@PathVariable Integer id){
        return movieService.updateMovieById(id);
    }

//    @GetMapping("getMovie/isPlaying")
//    public Result getMoviesByIsPlaying(){
//        return movieService.getMoviesByIsPlaying();
//    }
//
//    @GetMapping("/getMovie/isComing")
//    public Result getMoviesIsComing(){
//        return movieService.getMoviesIsComing();
//    }
//
//    @GetMapping("/getMovie/isOutTheater")
//    public Result getMoviesIsOutTheater(){
//        return movieService.getMoviesIsOutTheater();
//    }
}
