const API_URL = "http://localhost:8080/api/species";

export async function getSpecies() {
    const TOKEN = localStorage.getItem("jwtToken");
    const response = await fetch(API_URL,{
        method: "GET",
        headers: {
            "Authorization":`Bearer ${TOKEN}`,
        }
    });

    if (!response.ok) {
        throw new Error("Failed to fetch species");
    }

    return response.json();
}
