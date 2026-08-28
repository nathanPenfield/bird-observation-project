import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar/Navbar.jsx"
import ObservationForm from "../components/ObservationForm/ObservationForm.jsx"
import { createObservation } from "../services/ObservationService.js";
import "./LogSighting.css";

function LogSighting (){
    const navigate = useNavigate();
    
    // states
    const [error,setError] = useState("");

    const handleSubmit = async (formData) => {
        setError("");

        try {
            await createObservation(formData.speciesId, formData.count, formData.location, formData.date, formData.time, formData.notes);
            navigate('/mysightings')        
        } catch (error) {
            setError(error.message);
        }
    };



    return(
        <>
            <Navbar/>
            <main className="log-page page">
                <div className="log-intro">
                    <p className="log-eyebrow">Add to your field notes</p>
                    <h1>Log a sighting</h1>
                    <p className="log-description">Capture the details while they are still fresh.</p>
                </div>
                <ObservationForm handleSubmit={handleSubmit} error={error} data={{speciesId:-1}}/>
            </main>
        </>
    );
}
export default LogSighting