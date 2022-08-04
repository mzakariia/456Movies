import { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import MoviesContainer from "./MoviesContainer";
import SearchBox from "./SearchBox";
import axios from "axios";
import "./Search.css";

const Search = () => {
  const params = useParams();
  let query = params.query.split(" ").join("%20");
  if (query == "") query = "none";
  const queryUrl =
    "http://localhost:8080/search/movie?query=" + query + "&page=1";
  const [movies, setMovies] = useState([]);
  useEffect(() => {
    const fetchMovies = async () => {
      return axios.get(queryUrl);
    };
    fetchMovies().then((response) => {
      console.log(response);
      setMovies(response.data);
    });
  });
  return (
    <>
      {/* <NavBar /> */}
      <Link className="link" to="/">
        <h1 className="name">456Movies</h1>
      </Link>
      <SearchBox />
      <h2 className="searchResults">Results for "{params.query}"</h2>
      <MoviesContainer movies={movies} />
    </>
  );
};

export default Search;
