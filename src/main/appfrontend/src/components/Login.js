import React, { useState } from "react";
import { loginUser } from "../services/api";
import TaskList from "./TaskList";
import { Link } from "react-router-dom";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [success, setSuccess] = useState("");
  const [userId, setUserId] = useState(null);

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const userData = await loginUser(email, password);
      setUserId(userData.id); // Save the logged-in user's ID
      setSuccess("Login successful!");
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div>
      {userId ? (
        // If logged in, show the task list
        <TaskList userId={userId} />
      ) : (
        // Otherwise, show the login form
        <div>
          <h2>Login</h2>
          {error && <p style={{ color: "red" }}>{error}</p>}
          {success && <p style={{ color: "green" }}>{success}</p>}
          <form onSubmit={handleLogin}>
            <div>
              <label>Email:</label>
              <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
            </div>
            <div>
              <label>Password:</label>
              <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
            </div>
            <button type="submit">Login</button>
          </form>
          <p>
            Don’t have an account? <Link to="/register">Register here</Link>.
          </p>
        </div>
      )}
    </div>
  );
};

export default Login;
