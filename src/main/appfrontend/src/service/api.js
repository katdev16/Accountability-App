import axios from "axios";

const API_URL = "http://localhost:8080"; // Replace with your backend URL

// Login user
export const loginUser = async (email, password) => {
  try {
    const response = await axios.post(`${API_URL}/users/login`, { email, password });
    return response.data; // Token or user data
  } catch (error) {
    throw new Error(error.response?.data?.message || "Login failed");
  }
};

// Register new user
export const registerUser = async (userData) => {
  try {
    const response = await axios.post(`${API_URL}/users`, userData);
    return response.data; // Newly created user
  } catch (error) {
    throw new Error(error.response?.data?.message || "Registration failed");
  }
};
