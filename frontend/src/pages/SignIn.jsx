import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./AuthPage.css";
import Navbar from "../components/Navbar/Navbar";
import { authorizeUser } from "../services/UserService";

function SignIn() {
    const navigation = useNavigate();
    const [errorMsg,setErrorMsg] = useState("");
    const [formData, setFormData] = useState({
        email: "",
        password: "",
    });

    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData((prev) => ({
            ...prev,
            [name]: value,
        }));
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try{
            await authorizeUser(formData.email,formData.password);
            navigation("/mysightings");
        }catch(error){
            setErrorMsg(error.message);
        }
        
    
    };

    return (
        <>
            <Navbar/>
            <main className="auth-page">
                <div className="auth-card">
                    <div className="auth-header">
                        <p className="auth-eyebrow">Welcome back</p>
                        <h1>Sign in</h1>
                    </div>

                    <form className="auth-form" onSubmit={handleSubmit}>
                        <label className="auth-field">
                            <span>Email</span>
                            <input
                                type="email"
                                name="email"
                                placeholder="you@example.com"
                                value={formData.email}
                                onChange={handleChange}
                                required
                            />
                        </label>

                        <label className="auth-field">
                            <span>Password</span>
                            <input
                                type="password"
                                name="password"
                                placeholder="Enter your password"
                                value={formData.password}
                                onChange={handleChange}
                                required
                            />
                        </label>
                        {errorMsg && <p>{errorMsg}</p> }
                        <button className="auth-submit" type="submit">
                            Sign in
                        </button>
                    </form>

                    <p className="auth-switch">
                        Don&apos;t have an account? <Link to="/signup">Create one</Link>
                    </p>
                </div>
            </main>
        </>
    );
}

export default SignIn;
