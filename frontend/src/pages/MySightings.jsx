import { useState, useEffect } from 'react';
import { getObservations } from '../services/ObservationService.js';

import Navbar from "../components/Navbar/Navbar.jsx"
import SightingCard from "../components/SightingCard/SightingCard.jsx"
import "./MySightings.css"

function MySightings(){
    const [sightings, setSightings] = useState([]);

    useEffect(()=>{
        async function loadSightings() {
            const data = await getObservations();
            setSightings(data)
        }

        loadSightings();
    },[]);

    return (
        <>
            <Navbar/>
            <h1>My Sightings</h1>
            <ol className="sightings">
                {sightings.map((sighting)=>(
                    <SightingCard sighting={sighting} key={sighting.id}/>
                ))}
            </ol>
            
        </>
    );
}

export default MySightings