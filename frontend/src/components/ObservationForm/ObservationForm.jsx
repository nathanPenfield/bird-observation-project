import { useState } from "react";
import './ObservationForm.css'
import LocationInput from "./LocationInput.jsx";
import SpeciesInput from "./SpeciesInput.jsx";

function ObservationForm({handleSubmit, error, data}){
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

    return(
        <form className="log-form" onSubmit={submitAction}>
            <SpeciesInput defaultSpecies={data?.species?.name||""} setFormData={setFormData}/>
            <div className="form-field">
                <label htmlFor="count">Count</label>
                <input id="count" name="count" type="number" min="1" value={formData.count} onChange={handleChange}/>
            </div>
            <LocationInput defaultLocation={data?.location?.name||""} setFormData={setFormData}/>
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