package com.zakaria.task.movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("search")
@CrossOrigin
public class searchController {

    @Autowired
    MovieService movieService;

    @GetMapping(path = "movie")
    public List<Movie> searchMovies(@RequestParam("page") int page, @RequestParam("query") String query){
        return movieService.searchMovies(page,query);
    }
}
