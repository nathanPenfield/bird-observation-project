import { useState, useEffect, useRef } from "react";
import { getSpecies } from "../../services/SpeciesService.js";
import "./SpeciesInput.css"

function SpeciesInput ({defaultSpecies, setFormData}){
    const [species,setSpecies] = useState([]);
    const [speciesInput, setSpeciesInput] = useState(defaultSpecies||"");
    const [hideOptions, setHideOptions] = useState(false);
    const speciesInputRef = useRef(null);

    // species matching search term
    const matchingSpecies = species.filter((speciesOption) => {
        const searchValue = speciesInput.trim().toLowerCase();
        if (!searchValue) return false;
        return speciesOption.name.toLowerCase().includes(searchValue);
    });

    // update search term on user type
    const handleSpeciesInputChange = (e) => {
        const nextSpeciesName = e.target.value;
        setSpeciesInput(nextSpeciesName);
        setHideOptions(false);
        e.target.setCustomValidity("Select a bird species.");
        setFormData((currentFormData) => ({
            ...currentFormData,
            speciesId: -1,
        }));
    }

    // update form data when species selected
    const handleSpeciesSelect = (speciesOption) => {  
        setHideOptions(true);
        setSpeciesInput(speciesOption.name);
        speciesInputRef.current?.setCustomValidity("");
        setFormData((currentFormData) => ({
            ...currentFormData,
            speciesId: speciesOption.id,
        }));
    }


    useEffect(()=>{
        async function loadSpecies() {
            const data = await getSpecies();
            setSpecies(data)
        }
    
        loadSpecies();

        if(defaultSpecies){
            setHideOptions(true);
        }
    },[])

    return(
        <div className="form-field species-field">
            <label htmlFor="bird">Bird</label>
            <input
                id="bird"
                ref={speciesInputRef}
                name="birdName"
                type="text"
                value={speciesInput}
                onChange={handleSpeciesInputChange}
                placeholder="Type a bird species name"
                autoComplete="off"
                required
            />
            {speciesInput.trim() && !hideOptions && matchingSpecies.length > 0 && (
                    <div id="species-options-container" className="species-suggestions" role="listbox">
                        {matchingSpecies.slice(0, 6).map((speciesOption) => (
                            <button
                                type="button"
                                key={speciesOption.id}
                                className="species-suggestion"
                                onMouseDown={(event) => {
                                    event.preventDefault();
                                    handleSpeciesSelect(speciesOption);
                                }}
                            >
                                {speciesOption.name}
                            </button>
                        ))}
                    </div>
                )}
        </div>
    );
}

export default SpeciesInput;