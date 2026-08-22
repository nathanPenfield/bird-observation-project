import Logo from "../assets/logo.png"
import "./Navbar.css"

function Navbar(){
    return(
        <nav className="navbar">
            <a href="/"><img src={Logo} alt="ChirpLog Logo"></img></a>
            <div className="nav-container">
                <a href="/log">Log</a>
                <a href="/sightings">Observations</a>
                <a href="/account">Profile</a>
            </div>
        </nav>
    );
}

export default Navbar