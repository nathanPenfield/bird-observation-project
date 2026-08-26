import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar/Navbar.jsx"
import { createObservation } from "../services/ObservationService.js";
import { getSpecies } from "../services/SpeciesService.js";
import "./LogSighting.css";

function LogSighting (){
    const navigate = useNavigate();
    
    // form values
    const [birdId,setBirdId] = useState(-1);
    const [count,setCount] = useState(1);
    const [location,setLocation] = useState("");
    const [date,setDate] = useState("");
    const [time,setTime] = useState("");
    const [notes,setNotes] = useState("");
    // helping states
    const [species,setSpecies] = useState([]);
    const [success,setSuccess] = useState(false);
    const [error,setError] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError("");

        try {
            await createObservation(birdId,count,location,date,time,notes);
            setSuccess(true);
        } catch (error) {
            setError(error.message);
        }
    };

    useEffect(()=>{
        if (success){
            navigate('/mysightings')
        }
    },[success])

    useEffect(()=>{
        async function loadSpecies() {
                const data = await getSpecies();
                setSpecies(data)
            }
    
            loadSpecies();
    },[])

    return(
        <>
            <Navbar/>
            <main className="log-page">
                <div className="log-intro">
                    <p className="log-eyebrow">Add to your field notes</p>
                    <h1>Log a sighting</h1>
                    <p className="log-description">Capture the details while they are still fresh.</p>
                </div>
                <form className="log-form" onSubmit={handleSubmit}>
                    <div className="form-field">
                        <label htmlFor="bird">Bird</label>
                        <select id="bird" value={birdId} onChange={(e)=>{setBirdId(e.target.value)}}>
                            <option value={-1}>Select a species</option>
                            {species.map((speciesOption) => (
                                <option key={speciesOption.id} value={speciesOption.id}>
                                    {speciesOption.name}
                                </option>
                            ))}
                        </select>
                    </div>
                    <div className="form-field">
                        <label htmlFor="count">Count</label>
                        <input id="count" type="number" min="1" value={count} onChange={(e)=>{setCount(e.target.value)}}/>
                    </div>
                    <div className="form-field form-field-wide">
                        <label htmlFor="location">Location</label>
                        <input id="location" value={location} onChange={(e)=>{setLocation(e.target.value)}}/>
                    </div>
                    <div className="form-field">
                        <label htmlFor="date">Date</label>
                        <input id="date" type="date" value={date} onChange={(e)=>{setDate(e.target.value)}}/>
                    </div>
                    <div className="form-field">
                        <label htmlFor="time">Time</label>
                        <input id="time" type="time" value={time} onChange={(e)=>{setTime(e.target.value)}}/>
                    </div>
                    <div className="form-field form-field-wide">
                        <label htmlFor="notes">Notes <span>(optional)</span></label>
                        <textarea id="notes" rows="4" value={notes} onChange={(e)=>{setNotes(e.target.value)}} />
                    </div>
                    <div className="form-actions">
                        <button type="submit">Log sighting</button>
                        {error && <p className="form-error">{error}</p>}
                    </div>
                </form>
            </main>
        </>
    );
}
export default LogSighting