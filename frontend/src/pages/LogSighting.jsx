import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar/Navbar.jsx"
import { createObservation } from "../services/ObservationService.js";
import { getSpecies } from "../services/SpeciesService.js";

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
            <h1>Log A Sighting</h1>
            <form onSubmit={handleSubmit}>
                <label>Bird:</label>
                <select value={birdId} onChange={(e)=>{setBirdId(e.target.value)}}>
                    <option value={-1}>Select a species</option>
                    {species.map((speciesOption) => (
                        <option key={speciesOption.id} value={speciesOption.id}>
                            {speciesOption.name}
                        </option>
                    ))}
                </select>
                <label>Count:</label>
                <input value={count} onChange={(e)=>{setCount(e.target.value)}}/>
                <label>Location:</label>
                <input value={location} onChange={(e)=>{setLocation(e.target.value)}}/>
                <label>Date:</label>
                <input type="date" value={date} onChange={(e)=>{setDate(e.target.value)}}/>
                <label>Time:</label>
                <input type="time" value={time} onChange={(e)=>{setTime(e.target.value)}}/>
                <label>Notes (optional):</label>
                <input value={notes} onChange={(e)=>{setNotes(e.target.value)}}/>
                <button>Log Sighting</button>
                {error && <p>{error}</p>}
            </form>
        </>
    );
}
export default LogSighting