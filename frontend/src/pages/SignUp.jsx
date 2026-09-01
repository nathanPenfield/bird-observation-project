import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./AuthPage.css";
import Navbar from "../components/Navbar/Navbar";
import { createUser } from "../services/UserService";

function SignUp() {
    const navigation = useNavigate();
    const [errorMsg,setErrorMsg] = useState("");
    const [formData, setFormData] = useState({
        name: "",
        email: "",
        password: "",
        confirmPassword: "",
    });

    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData((prev) => ({
            ...prev,
            [name]: value,
        }));
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        try{
            if (formData.confirmPassword == formData.password){
                createUser(formData.name, formData.email, formData.password, formData.confirmPassword);
                navigation("/signin");
            } else{
                setErrorMsg("Passwords don't match.")
                return;
            }
        } catch (error){
            console.log(error);
        }
    };

    return (
        <>
            <Navbar/>
            <main className="auth-page">
                <div className="auth-card">
                    <div className="auth-header">
                        <p className="auth-eyebrow">Join us</p>
                        <h1>Create account</h1>
                    </div>

                    <form className="auth-form" onSubmit={handleSubmit}>
                        <label className="auth-field">
                            <span>Name</span>
                            <input
                                type="text"
                                name="name"
                                placeholder="Your full name"
                                value={formData.name}
                                onChange={handleChange}
                                required
                            />
                        </label>

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
                                placeholder="Create a password"
                                value={formData.password}
                                onChange={handleChange}
                                required
                            />
                        </label>

                        <label className="auth-field">
                            <span>Confirm password</span>
                            <input
                                type="password"
                                name="confirmPassword"
                                placeholder="Confirm your password"
                                value={formData.confirmPassword}
                                onChange={handleChange}
                                required
                            />
                        </label>
                        {errorMsg && <p>{errorMsg}</p> }
                        <button className="auth-submit" type="submit">
                            Sign up
                        </button>
                    </form>

                    <p className="auth-switch">
                        Already have an account? <Link to="/signin">Sign in</Link>
                    </p>
                </div>
            </main>
        </>
    );
}

export default SignUp;
