const API_URL = "http://localhost:8080/api/observations";

export async function getObservations() {
    const TOKEN = localStorage.getItem("jwtToken");
    const response = await fetch(API_URL,{
        method: "GET",
        headers: {
            "Authorization":`Bearer ${TOKEN}`,
            
        }
    });

    if (!response.ok) {
        throw new Error("Failed to fetch observations");
    }

    return response.json();
}

export async function getObservationById(id){
    const TOKEN = localStorage.getItem("jwtToken");
    const response = await fetch(API_URL+`/${id}`,{
        method: "GET",
        headers: {
            "Authorization":`Bearer ${TOKEN}`,
            
        }
    });

    if (!response.ok){
        throw new Error("Failed to fetch observation with id: "+id);
    }

    return response.json();
}

export async function createObservation(species_id, count, location_id, date, time, notes){
    const TOKEN = localStorage.getItem("jwtToken");
    const response = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Authorization":`Bearer ${TOKEN}`,
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "species_id":species_id,
            "count":count,
            "location_id":location_id,
            "date":date,
            "time":time,
            "notes":notes    
        })
    });

    if (!response.ok) {
        throw new Error("Failed to create observation");
    }

    return;
}

export async function deleteObservationById(id){
    const TOKEN = localStorage.getItem("jwtToken");
    const response = await fetch(API_URL+`/${id}`,{
        method:"DELETE",
        headers: {
            "Authorization":`Bearer ${TOKEN}`,
        }
    });

    if (!response.ok){
        throw new Error(`Failed to delete observation with id: ${id}`);
    }

    return;
}

export async function updateObservation(id, species_id, count, location_id, date, time, notes){
    const TOKEN = localStorage.getItem("jwtToken");
    const response = await fetch(API_URL+`/${id}`, {
        method: "PUT",
        headers: {
            "Authorization":`Bearer ${TOKEN}`,
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "id":id,
            "species_id":species_id,
            "count":count,
            "location_id":location_id,
            "date":date,
            "time":time,
            "notes":notes   
        })
    });

    if (!response.ok) {
        throw new Error("Failed to update observation");
    }

    return;
}