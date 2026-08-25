import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { getObservationById } from "../services/ObservationService";

import Navbar from "../components/Navbar/Navbar";
import { Link } from "react-router-dom";
import "./IndividualSighting.css";

function IndividualSighting(){
    const {id} = useParams();
    const [sighting,setSighting] = useState();
    const [error, setError] = useState(false);

    useEffect(() => {
        async function loadSighting(){
            try {
                const data = await getObservationById(id);
                setSighting(data);
            } catch {
                setError(true);
            }
        }
        loadSighting();
    },[id]);

    return(
        <>
            <Navbar/>
            <main className="sighting-detail">
                {error ? (
                    <section className="sighting-state">
                        <p className="eyebrow">Field note unavailable</p>
                        <h1>We couldn’t find that sighting.</h1>
                        <Link className="back-link" to="/mysightings">Back to My Sightings</Link>
                    </section>
                ) : sighting ? (
                    <>
                        <Link className="back-link" to="/mysightings">&larr; Back to My Sightings</Link>
                        <section className="sighting-hero">
                            <h1>{sighting.species.name}</h1>
                            <p className="sighting-date">Spotted on {sighting.date} at {sighting.time}</p>
                        </section>

                        <section className="sighting-facts" aria-label="Observation details">
                            <div className="fact">
                                <span className="fact-label">Location</span>
                                <strong>{sighting.location}</strong>
                            </div>
                            <div className="fact">
                                <span className="fact-label">Count</span>
                                <strong>{sighting.count} {sighting.count === 1 ? "bird" : "birds"}</strong>
                            </div>
                            <div className="fact">
                                <span className="fact-label">Date</span>
                                <strong>{sighting.date}</strong>
                            </div>
                            <div className="fact">
                                <span className="fact-label">Time</span>
                                <strong>{sighting.time}</strong>
                            </div>
                        </section>
                        
                        
                        {sighting.notes?.trim() && (
                            <section className="notes-panel">
                                <div>
                                    <p className="eyebrow">From the field</p>
                                    <h2>Notes</h2>
                                </div>
                                <p className="notes-copy">{sighting.notes}</p>
                            </section>
                        )}
                    </>
                ) : (
                    <section className="sighting-state">
                        <p className="eyebrow">Loading field note</p>
                        <h1>Following the trail...</h1>
                    </section>
                )}
            </main>
        </>
    );
}

export default IndividualSighting;