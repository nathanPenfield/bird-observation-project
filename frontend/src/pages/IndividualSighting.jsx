import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { getObservationById } from "../services/ObservationService";

import Navbar from "../components/Navbar/Navbar";
import SightingCard from "../components/SightingCard/SightingCard";

function IndividualSighting(){
    const {id} = useParams();
    const [sighting,setSighting] = useState();

    useEffect(() => {
        async function loadSighting(){
            const data = await getObservationById(id);
            setSighting(data);
        }
        loadSighting();
    },[id]);

    return(
        <>
            <Navbar/>
            {sighting && <SightingCard sighting={sighting}/>}
        </>
    );
}

export default IndividualSighting;