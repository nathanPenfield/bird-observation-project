import { useNavigate, useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { getObservationById, deleteObservationById, updateObservation } from "../services/ObservationService";
import ObservationForm from "../components/ObservationForm/ObservationForm"
import Navbar from "../components/Navbar/Navbar";
import { Link } from "react-router-dom";
import "./IndividualSighting.css";

function IndividualSighting(){
    const navigate = useNavigate();
   
    const {id} = useParams();
    const [sighting,setSighting] = useState();
    const [update, setUpdate] = useState(false);
    const [error, setError] = useState("");

    const deleteObservation = async ()=>{
        try{
            await deleteObservationById(id);
            navigate("/mysightings")
        }catch{
            error("Unable to delete observation");
        }
    }
    
    const handleUpdate = async (formData)=>{
        try{
            await updateObservation(id, formData.speciesId, formData.count, formData.location, formData.date, formData.time, formData.notes);
            setUpdate(false);
        }catch{
            setError("Unable to update observation");
        }
    }

    useEffect(() => {
        async function loadSighting(){
            try {
                const data = await getObservationById(id);
                setSighting(data);
            } catch {
                navigate("/404");
            }
        }
        loadSighting();
    },[id]);

    return(
        <>
            <Navbar/>
            <main className="sighting-detail page">
                {update ? (
                    <ObservationForm handleSubmit={handleUpdate} error={error} data={sighting}/>
                ) : sighting ? (
                    <>
                        <Link className="back-link" to="/mysightings">&larr; Back to My Sightings</Link>
                        <section className="sighting-hero">
                            <p className="eyebrow">Observation record</p>
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

                        <section className="sighting-actions" aria-label="Observation actions">
                            <div>
                                <p className="eyebrow">Manage record</p>
                            </div>
                            <div className="observation-buttons">
                                <button type="button" className="edit-button" onClick={()=>{setUpdate(true)}}>
                                    Edit observation
                                </button>
                                <button type="button" className="delete-button" onClick={deleteObservation}>
                                    Delete observation
                                </button>
                            </div>
                        </section>
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