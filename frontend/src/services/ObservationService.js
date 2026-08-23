const API_URL = "http://localhost:8080/api/observations";

export async function getObservations() {
    const response = await fetch(API_URL);

    if (!response.ok) {
        throw new Error("Failed to fetch observations");
    }

    return response.json();
}