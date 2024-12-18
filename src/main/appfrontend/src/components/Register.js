import React, { useState } from "react";
import { registerUser } from "../services/api";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";

const Register = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [success, setSuccess] = useState("");
  const navigate = useNavigate();

  const handleRegister = async (e) => {
    e.preventDefault();
    try {
      // const newUser = await registerUser({ name, email });
      // setSuccess("User registered successfully!");
      // console.log("New user created:", newUser);

      const userData = { name, email, password };

      // Call the API to register the user
      const createdUser = await registerUser(userData);

      // Show success message
      setSuccess(`User "${createdUser.name}" registered successfully! Redirecting...`);
      setTimeout(() => navigate("/"), 2000);
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div>
      <h2>Register</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}
      {success && <p style={{ color: "green" }}>{success}</p>}
      <form onSubmit={handleRegister}>
        <div>
          <label>Name:</label>
          <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />
        </div>
        <div>
          <label>Email:</label>
          <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)}  />
        </div>
        <button type="submit">Register</button>
      </form>
      <p>
        Already have an account? <Link to="/">Login here</Link>.
      </p>
    </div>
  );
};

export default Register;
