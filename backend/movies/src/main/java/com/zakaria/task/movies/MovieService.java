package com.zakaria.task.movies;

import com.zakaria.task.models.response.MoviesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class MovieService {

    static String movieDB = "https://api.themoviedb.org/3/";
    static String apiKey = "a97243d7813d31446f6c43284e6854d5";

    static String queryString = "?api_key="+apiKey+"&language=en-US";
    @Autowired
    MovieRepository movieRepository;
    public Movie getMovie(int movieId){
        Optional<Movie> returnedMovie =  movieRepository.findById(movieId);
        Movie movie = null;
        if(returnedMovie.isPresent()) movie = returnedMovie.get();
        else {
            String url = movieDB+"movie/"+movieId+queryString;
            RestTemplate restTemplate = new RestTemplate();
            movie = restTemplate.getForObject( url , Movie.class);
            movieRepository.save(movie);
        }
        System.out.println(movie.toString());
        return movie;
    }

    public List<Movie> getPopularMovies(int page){
        String url = movieDB+"movie/popular"+queryString+"&page="+page;
        RestTemplate restTemplate = new RestTemplate();
        MoviesResponse response
                = restTemplate.getForObject(url, MoviesResponse.class);
        return response.getResults();
    }

    public List<Movie> searchMovies(int page, String query) {
        String url = movieDB+"search/movie"+queryString+"&query="+query+"&page="+page;
        RestTemplate restTemplate = new RestTemplate();
        MoviesResponse response
                = restTemplate.getForObject(url, MoviesResponse.class);
        return response.getResults();

    }
}
