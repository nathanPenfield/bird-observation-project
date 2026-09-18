import Navbar from "../components/Navbar/Navbar";
import { useAuth } from "../context/AuthContext.jsx";
import "./Profile.css";

function Profile() {
    const { user } = useAuth();

    return (
        <>
            <Navbar />
            <main className="profile-page page">
                <h1>Welcome {user.name}</h1>
                <p>Your name, email, and securely stored password are used only to support your account login.</p>
            </main>
        </>
    );
}

export default Profile;
