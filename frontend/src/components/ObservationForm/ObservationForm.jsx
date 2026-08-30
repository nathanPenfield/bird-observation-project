import { getSpecies } from "../../services/SpeciesService.js";
import { getLocations } from "../../services/LocationService.js"
import { useState, useEffect } from "react";
import './ObservationForm.css'

function ObservationForm({handleSubmit, error, data}){
    const [species,setSpecies] = useState([]);
    const [locations,setLocations] = useState([]);
    
    const [formData, setFormData] = useState({
        speciesId: data?.speciesId || data?.species?.id || -1,
        count: data?.count || 1,
        locationId: data?.locationId || data?.location?.id || "",
        date: data?.date || "",
        time: data?.time || "",
        notes: data?.notes || ""
    })

    const handleChange = (e)=>{
        setFormData({
            ... formData,
            [e.target.name]:e.target.value
        });
    }
    const submitAction = (e)=>{
        e.preventDefault();
        handleSubmit(formData);
    }

    useEffect(()=>{
        async function loadSpecies() {
            const data = await getSpecies();
            setSpecies(data)
        }
        async function loadLocations() {
            const data = await getLocations();
            setLocations(data);
        }
    
        loadSpecies();
        loadLocations();
    },[])

    return(
        <form className="log-form" onSubmit={submitAction}>
            <div className="form-field">
                <label htmlFor="bird">Bird</label>
                <select id="bird" name="speciesId" value={formData.speciesId} onChange={handleChange}>
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
                <input id="count" name="count" type="number" min="1" value={formData.count} onChange={handleChange}/>
            </div>
            <div className="form-field form-field-wide">
                <label htmlFor="location">Location</label>
                <select id="location" name="locationId" value={formData.locationId} onChange={handleChange}>
                    <option value={-1}>Select a location</option>
                    {locations.map((locationOption) => (
                        <option key={locationOption.id} value={locationOption.id}>
                            {locationOption.name}
                        </option>
                    ))}
                </select>
            </div>
            <div className="form-field">
                <label htmlFor="date">Date</label>
                <input id="date" name="date" type="date" value={formData.date} onChange={handleChange}/>
            </div>
            <div className="form-field">
                <label htmlFor="time">Time</label>
                <input id="time" name="time" type="time" value={formData.time} onChange={handleChange}/>
            </div>
            <div className="form-field form-field-wide">
                <label htmlFor="notes">Notes <span>(optional)</span></label>
                <textarea id="notes" name="notes" rows="4" value={formData.notes} onChange={handleChange} />
            </div>
            <div className="form-actions">
                <button type="submit">Log sighting</button>
                {error && <p className="form-error">{error}</p>}
            </div>
        </form>
    );
}

export default ObservationForm;