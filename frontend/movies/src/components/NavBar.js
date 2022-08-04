import "./NavBar.css";
import { Link } from "react-router-dom";

const NavBar = () => {
  return (
    <div className="navBar">
      <Link className="link" to="/">
        <h1 className="navItem">Home</h1>
      </Link>
      <Link className="link" to="/popular">
        <h1 className="navItem"> Popular Movies</h1>
      </Link>
    </div>
  );
};

export default NavBar;
