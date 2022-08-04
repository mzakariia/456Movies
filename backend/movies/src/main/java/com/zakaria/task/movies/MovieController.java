package com.zakaria.task.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "movie")
@CrossOrigin
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping(path = "{movieId}")
    public Movie getMovie(@PathVariable int movieId){
        return movieService.getMovie(movieId);
    }

    @GetMapping(path = "popular")
    public List<Movie> getPopularMovies(@RequestParam("page") int page){
        return movieService.getPopularMovies(page);
    }

}
