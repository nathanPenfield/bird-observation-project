import { useEffect, useState } from "react";
import { getLocations } from "../../services/LocationService";
import "./LocationInput.css"



function LocationInput({defaultLocation, setFormData}){
    const [locations,setLocations] = useState([]);
    const [locationInput,setLocationInput] = useState(defaultLocation || "");
    const [addLocationError,setAddLocationError] = useState("");
    const [showAddLocation,setShowAddLocation] = useState(false);
    const [hideOptions, setHideOptions] = useState(false);

    // locations matching search term
    const matchingLocations = locations.filter((locationOption) => {
        const searchValue = locationInput.trim().toLowerCase();
        if (!searchValue) return false;
        return locationOption.name.toLowerCase().includes(searchValue);
    });

    // update search term on user type
    const handleLocationInputChange = (e) => {
        const nextLocationName = e.target.value;
        setShowAddLocation(true);
        setLocationInput(nextLocationName);
        setAddLocationError("");
        setHideOptions(false);
    }

    // update form data when location selected
    const handleLocationSelect = (locationOption) => {  
        setHideOptions(true);
        setLocationInput(locationOption.name);
        setAddLocationError("");
        setFormData((currentFormData) => ({
            ...currentFormData,
            locationId: locationOption.id,
        }));
        setShowAddLocation(false);   
    }

    // adding location
    const handleAddLocation = async () => {        
        setAddLocationError("The ability to add locations does not exist yet.");
        return;
    }

    // load locations
    useEffect(()=>{
            async function loadLocations() {
                const data = await getLocations();
                setLocations(data);
            }

            loadLocations();

            if(defaultLocation){
                setHideOptions(true);
            }
    },[])
    return (
        <div className="form-field form-field-wide location-field">
                <label htmlFor="location">Location</label>
                <input
                    id="location"
                    name="locationName"
                    type="text"
                    value={locationInput}
                    onChange={handleLocationInputChange}
                    placeholder="Type a location name"
                    autoComplete="off"
                />
                {locationInput.trim() && !hideOptions && matchingLocations.length > 0 && (
                    <div id="location-options-container" className="location-suggestions" role="listbox">
                        {matchingLocations.slice(0, 6).map((locationOption) => (
                            <button
                                type="button"
                                key={locationOption.id}
                                className="location-suggestion"
                                onMouseDown={(event) => {
                                    event.preventDefault();
                                    handleLocationSelect(locationOption);
                                }}
                            >
                                {locationOption.name}
                            </button>
                        ))}
                    </div>
                )}
                {locationInput.trim() && showAddLocation && (
                    <button type="button" className="add-location-button" onClick={handleAddLocation}>
                        Add location
                    </button>
                )}
                {addLocationError && <p className="form-error">{addLocationError}</p>}
            </div>
    );
}

export default LocationInput;