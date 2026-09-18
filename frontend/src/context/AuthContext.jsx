import { createContext, useContext, useState } from "react";

const AuthContext = createContext(null);

function readStoredUser() {
    const token = localStorage.getItem("jwtToken");
    const storedUser = localStorage.getItem("authUser");

    if (!token || !storedUser) {
        return null;
    }

    try {
        return JSON.parse(storedUser);
    } catch {
        return null;
    }
}

export function AuthProvider({ children }) {
    const [user, setUser] = useState(readStoredUser);

    const setAuthenticatedUser = (authenticatedUser) => {
        setUser(authenticatedUser);
    };

    const signOut = () => {
        localStorage.removeItem("jwtToken");
        localStorage.removeItem("authUser");
        setUser(null);
    };

    return (
        <AuthContext.Provider
            value={{
                user,
                isAuthorized: Boolean(user),
                setAuthenticatedUser,
                signOut,
            }}
        >
            {children}
        </AuthContext.Provider>
    );
}

export function useAuth() {
    return useContext(AuthContext);
}
