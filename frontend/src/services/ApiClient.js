const AUTH_EXPIRED_EVENT = "auth:expired";

function tokenIsExpired(token) {
    try {
        const encodedPayload = token.split(".")[1]
            .replace(/-/g, "+")
            .replace(/_/g, "/");
        const payload = JSON.parse(atob(encodedPayload));
        return typeof payload.exp !== "number" || payload.exp * 1000 <= Date.now();
    } catch {
        return true;
    }
}

export async function authenticatedFetch(url, options = {}) {
    const token = localStorage.getItem("jwtToken");

    if (token && tokenIsExpired(token)) {
        window.dispatchEvent(new Event(AUTH_EXPIRED_EVENT));
        return new Response(null, { status: 401, statusText: "Unauthorized" });
    }

    const headers = new Headers(options.headers);

    if (token) {
        headers.set("Authorization", `Bearer ${token}`);
    }

    const response = await fetch(url, { ...options, headers });

    if (response.status === 401) {
        window.dispatchEvent(new Event(AUTH_EXPIRED_EVENT));
    }

    return response;
}

export { AUTH_EXPIRED_EVENT };