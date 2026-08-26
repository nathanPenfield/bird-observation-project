import Navbar from "../components/Navbar/Navbar";
import "./Home.css";

function Home(){
    return(
        <>
            <Navbar/>
            <main className="page">
                <h1>ChirpLog</h1>
                <h3>See it. Say it. Log it.</h3>
            </main>
        </>
    );
}

export default Home;