import Logo from "../../assets/logo.png"
import "./Navbar.css"
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext.jsx";

function Navbar(){
    const { user, isAuthorized, signOut } = useAuth();
    const navigate = useNavigate();

    const handleSignOut = () => {
        signOut();
        navigate("/signin");
    };

    return(
        <nav className="navbar">
            <div className="navbar-brand">
                <Link to="/"><img src={Logo} alt="ChirpLog Logo"></img></Link>
                {isAuthorized && <span className="welcome-message">Welcome {user.name}</span>}
            </div>
            <div className="nav-container">
                <Link to="/log">Log</Link>
                <Link to="/mysightings">My Sightings</Link>
                <Link to="/account">Profile</Link>
                <Link to="/about">About</Link>
                {isAuthorized ? <button type="button" onClick={handleSignOut}>Sign Out</button> : <Link to="/signin">Sign In</Link>}
                {!isAuthorized && <Link to="/signup">Sign Up</Link>}
            </div>
        </nav>
    );
}

export default Navbar