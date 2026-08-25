const API_URL = "http://localhost:8080/api/observations";

export async function getObservations() {
    const response = await fetch(API_URL);

    if (!response.ok) {
        throw new Error("Failed to fetch observations");
    }

    return response.json();
}

export async function getObservationById(id){
    const response = await fetch(API_URL+`/${id}`);

    if (!response.ok){
        throw new Error("Failed to fetch observation with id: "+id);
    }

    return response.json();
}

export async function createObservation(species_id, count, location, date, time, notes){
    const response = await fetch("http://localhost:8080/api/observations", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "species_id":species_id,
            "count":count,
            "location":location,
            "date":date,
            "time":time,
            "notes":notes    
        })
    });

    if (!response.ok) {
        throw new Error("Failed to create observation");
    }

    return response.json();
}