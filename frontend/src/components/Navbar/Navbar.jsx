import Logo from "../../assets/logo.png"
import "./Navbar.css"
import { Link } from "react-router-dom";

function Navbar(){
    return(
        <nav className="navbar">
            <Link to="/"><img src={Logo} alt="ChirpLog Logo"></img></Link>
            <div className="nav-container">
                <Link to="/log">Log</Link>
                <Link to="/mysightings">My Sightings</Link>
                <Link to="/account">Profile</Link>
                <Link to="/about">About</Link>
                <Link to="/signin">Sign In</Link>
                <Link to="/signup">Sign Up</Link>
            </div>
        </nav>
    );
}

export default Navbar