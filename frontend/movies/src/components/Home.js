import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import MoviesContainer from "./MoviesContainer";
import SearchBox from "./SearchBox";
import axios from "axios";
import "./Home.css";

const Home = () => {
  const [movies, setMovies] = useState([]);
  const popularMoviesUrl = "http://localhost:8080/movie/popular?page=1";
  useEffect(() => {
    console.log("entered useEffect");
    const fetchMovies = async () => {
      const res = await axios.get(popularMoviesUrl);
      return res;
    };
    fetchMovies().then((response) => {
      setMovies(response.data);
    });
  }, []);
  return (
    <>
      <h1 className="greeting">
        Welcome to{" "}
        <Link className="link" to="/">
          <span className="name">456Movies</span>
        </Link>
      </h1>
      <SearchBox />
      <h2 className="popularMovies">Popular Movies</h2>
      <MoviesContainer movies={movies} />
    </>
  );
};

export default Home;
