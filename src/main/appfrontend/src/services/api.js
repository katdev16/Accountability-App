import axios from "axios";

const API_URL = "http://localhost:8080"; // Replace with your backend URL

// Login user
export const loginUser = async (email, password) => {
  try {
    const response = await axios.post(`${API_URL}/users/login`, { email, password });
    return response.data; // User data or token
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

// Fetch tasks for a specific user
export const fetchTasksForUser = async (userId) => {
  try {
    const response = await axios.get(`${API_URL}/users/${userId}/tasks`);
    return response.data; // List of tasks
  } catch (error) {
    throw new Error(error.response?.data?.message || "Failed to fetch tasks");
  }
};

// Mark a task as completed
export const markTaskAsCompleted = async (taskId) => {
  try {
    const response = await axios.put(`${API_URL}/tasks/${taskId}/completed`);
    return response.data; // Updated task
  } catch (error) {
    throw new Error(error.response?.data?.message || "Failed to update task");
  }
};
