const API_URL = "http://localhost:8080/api/user"

export async function createUser(name, email, password1, password2){
    
    if(password1==password2){
        const response = await fetch(API_URL, {
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
            throw new Error("Failed to create user");
        }

        return response.json();
    }else{
        throw new Error("Passwords don't match");
    }
}