const API_URL = "http://localhost:8080/api/species";
import { authenticatedFetch } from "./ApiClient.js";

export async function getSpecies() {
    const response = await authenticatedFetch(API_URL,{
        method: "GET",
    });

    if (!response.ok) {
        throw new Error("Failed to fetch species");
    }

    return response.json();
}
