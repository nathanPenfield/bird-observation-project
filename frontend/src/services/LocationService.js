const API_URL = "http://localhost:8080/api/locations";

export async function getLocations() {
    const TOKEN = localStorage.getItem("jwtToken");
    const response = await fetch(API_URL,{
        method:"GET",
        headers:{
            "Authorization":`Bearer ${TOKEN}`
        }
    });

    if (!response.ok) {
        throw new Error("Failed to fetch locations");
    }

    return response.json();
}

export async function createLocation(name,latitude,longitude) {
    const TOKEN = localStorage.getItem("jwtToken");
    const response = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Authorization":`Bearer ${TOKEN}`,
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
