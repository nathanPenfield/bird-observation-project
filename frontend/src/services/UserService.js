const API_URL = "http://localhost:8080/api/user"

export async function createUser(name, email, password1){
    const response = await fetch(API_URL+"/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ 
            "name":name ,
            "email":email,
            "password":password1
        })
    });

    if (!response.ok) { 
        const message = await response.text()
        throw new Error(message || "Failed to create user");
    }

    return response;
}

export async function authorizeUser(email, password){
    const response = await fetch(API_URL+"/auth", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ 
            "email":email,
            "password":password
        })
    });

    if (!response.ok) { 
        const message = await response.text()
        throw new Error(message || "Invalid Credentials");
    }
    
    const jsn = await response.json()
    localStorage.setItem("jwtToken",jsn.token);
    return response;
}