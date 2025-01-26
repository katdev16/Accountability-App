import axios from "axios";

// const API_URL = "http://localhost:8080"; 
const API_URL="https://accountability-app-3-ptjy.onrender.com"

// Login user
export const loginUser = async (email) => {
  try {
    const response = await axios.post(`${API_URL}/users/login`, { email});
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

// Add a new task for a user
export const addTaskForUser = async (userId, taskData) => {
  try {
    const response = await axios.post(`${API_URL}/users/${userId}/tasks`, taskData);
    return response.data; // Return the new task to be handled by the caller
  } catch (error) {
    throw new Error(error.response?.data?.message || "Failed to add task");
  }
};

export const TaskUpdate = async (updatedTask, setTasks) => {
  try {
    const response = await axios.put(`${API_URL}/tasks/${updatedTask.id}`, updatedTask);

    // Update state with the updated task from the backend
    setTasks((prevTasks) =>
      prevTasks.map((task) => (task.id === response.data.id ? response.data : task))
    );
  } catch (error) {
    console.error('Error updating task:', error);
    alert('Failed to update task. Please try again.');
  }
};


export const deleteTask = async (taskId) => {
  try {
    const response = await axios.delete(`${API_URL}/tasks/${taskId}`);
    return response.data; // Return success message
  } catch (error) {
    console.error("Error deleting task:", error);
    throw new Error(error.response?.data?.message || "Failed to delete task");
  }
};

