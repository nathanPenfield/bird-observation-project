const API_URL = "http://localhost:8080/api/observations";
import { authenticatedFetch } from "./ApiClient.js";

export async function getObservations() {
    const response = await authenticatedFetch(API_URL,{
        method: "GET",
    });

    if (!response.ok) {
        throw new Error("Failed to fetch observations");
    }

    return response.json();
}

export async function getObservationById(id){
    const response = await authenticatedFetch(API_URL+`/${id}`,{
        method: "GET",
    });

    if (!response.ok){
        throw new Error("Failed to fetch observation with id: "+id);
    }

    return response.json();
}

export async function createObservation(species_id, count, location_id, date, time, notes){
    const response = await authenticatedFetch(API_URL, {
        method: "POST",
        headers: {
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
    const response = await authenticatedFetch(API_URL+`/${id}`,{
        method:"DELETE",
    });

    if (!response.ok){
        throw new Error(`Failed to delete observation with id: ${id}`);
    }

    return;
}

export async function updateObservation(id, species_id, count, location_id, date, time, notes){
    const response = await authenticatedFetch(API_URL+`/${id}`, {
        method: "PUT",
        headers: {
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