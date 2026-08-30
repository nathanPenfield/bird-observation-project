const API_URL = "http://localhost:8080/api/locations";

export async function getLocations() {
    const response = await fetch(API_URL);

    if (!response.ok) {
        throw new Error("Failed to fetch locations");
    }

    return response.json();
}
