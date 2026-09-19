import { useState } from "react";
import { createLocation } from "../../services/LocationService";
import "./AddLocationForm.css";

function AddLocationForm({ initialName, onCreated, onCancel }) {
    const [name, setName] = useState(initialName || "");
    const [latitude, setLatitude] = useState("");
    const [longitude, setLongitude] = useState("");
    const [error, setError] = useState("");
    const [isSubmitting, setIsSubmitting] = useState(false);

    const handleSubmit = async () => {
        setError("");

        if (!name.trim()) {
            setError("Enter a location name.");
            return;
        }
        if (!latitude.trim()) {
            setError("Enter a latitude.");
            return;
        }
        if (!longitude.trim()) {
            setError("Enter a longitude.");
            return;
        }

        const parsedLatitude = Number(latitude);
        const parsedLongitude = Number(longitude);
        if (!Number.isFinite(parsedLatitude) || parsedLatitude < -90 || parsedLatitude > 90) {
            setError("Latitude must be a number between -90 and 90.");
            return;
        }
        if (!Number.isFinite(parsedLongitude) || parsedLongitude < -180 || parsedLongitude > 180) {
            setError("Longitude must be a number between -180 and 180.");
            return;
        }

        setIsSubmitting(true);
        try {
            const location = await createLocation(name.trim(), parsedLatitude, parsedLongitude);
            onCreated(location);
        } catch (requestError) {
            setError(requestError.message || "Failed to create location.");
        } finally {
            setIsSubmitting(false);
        }
    };

    return (
        <div className="add-location-form">
            <div className="add-location-form-header">
                <h3>Add location</h3>
                <button type="button" className="add-location-cancel" onClick={onCancel} disabled={isSubmitting}>
                    Cancel
                </button>
            </div>
            <div className="add-location-fields">
                <label>
                    Name
                    <input value={name} onChange={(event) => setName(event.target.value)} autoFocus />
                </label>
                <label>
                    Latitude
                    <input type="number" min="-90" max="90" step="any" required value={latitude} onChange={(event) => setLatitude(event.target.value)} />
                </label>
                <label>
                    Longitude
                    <input type="number" min="-180" max="180" step="any" required value={longitude} onChange={(event) => setLongitude(event.target.value)} />
                </label>
            </div>
            {error && <p className="form-error">{error}</p>}
            <button className="add-location-submit" type="button" onClick={handleSubmit} disabled={isSubmitting}>
                {isSubmitting ? "Adding..." : "Add location"}
            </button>
        </div>
    );
}

export default AddLocationForm;