import { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import axios from "axios";
import SearchBox from "./SearchBox";
import "./MovieDetails.css";
import dollar from "../icons/dollar.png";
import popular from "../icons/popularity.png";
import calendar from "../icons/calendar.png";
import notAvailable from "../images/notAvailable.png";

const MovieDetails = () => {
  const params = useParams();
  const movieId = params.id;
  const baseUrl = "http://localhost:8080/movie/";
  const imageBaseUrl = "https://images.tmdb.org/t/p/w500/";
  const [movie, setMovie] = useState({});
  useEffect(() => {
    const fetchDetails = async () => {
      const res = await axios.get(baseUrl + movieId);
      return res;
    };
    fetchDetails().then((response) => {
      console.log(response.data);
      setMovie(response.data);
    });
  }, []);
  return (
    <>
      <Link className="link" to="/">
        <h1 className="name">456Movies</h1>
      </Link>
      <SearchBox />
      <div className="moviePage">
        <img
          className="moviePagePoster"
          src={
            movie.poster_path ? imageBaseUrl + movie.poster_path : notAvailable
          }
          alt={movie.title + " poster"}
        />
        <div className="movieDetails">
          <h2 className="title">{movie.title}</h2>
          <div className="otherDetails">
            <img src={calendar} className="calendar" alt="calendar icon" />
            <p className="releaseDate">Released on {movie.release_date}</p>
            {movie.revenue ? (
              <>
                <img src={dollar} className="dollar" alt="dollar icon" />
                <p className="revenue">Revenuse: ${movie.revenue}</p>
              </>
            ) : (
              <></>
            )}
            <>
              <img src={popular} className="popular" alt="rating icon" />
              <p className="popularity">Popularity: {movie.popularity}</p>
            </>
          </div>
          <p className="description">{movie.overview}</p>
        </div>
      </div>
    </>
  );
};

export default MovieDetails;
