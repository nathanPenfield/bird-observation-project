const API_URL = "http://localhost:8080/api/locations";
import { authenticatedFetch } from "./ApiClient.js";

export async function getLocations() {
    const response = await authenticatedFetch(API_URL,{
        method:"GET",
    });

    if (!response.ok) {
        throw new Error("Failed to fetch locations");
    }

    return response.json();
}

export async function createLocation(name,latitude,longitude) {
    const response = await authenticatedFetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ 
            "name":name ,
            "latitude":latitude,
            "longitude":longitude
        })
    });

    if (!response.ok) {
        throw new Error("Failed to create location");
    }

    return response.json();
}
