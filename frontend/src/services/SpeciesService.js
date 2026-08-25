const API_URL = "http://localhost:8080/api/species";

export async function getSpecies() {
    const response = await fetch(API_URL);

    if (!response.ok) {
        throw new Error("Failed to fetch species");
    }

    return response.json();
}
