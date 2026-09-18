import { Navigate, Outlet } from "react-router-dom";
import { useAuth } from "../context/AuthContext.jsx";

function ProtectedRoute() {
    const { isAuthorized } = useAuth();

    return isAuthorized ? <Outlet /> : <Navigate to="/signin" replace />;
}

export default ProtectedRoute;
