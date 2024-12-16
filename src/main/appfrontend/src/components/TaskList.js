import React, { useState, useEffect } from "react";
import { fetchTasksForUser, markTaskAsCompleted } from "../services/api";

const TaskList = ({ userId }) => {
  const [tasks, setTasks] = useState([]);
  const [error, setError] = useState("");

  // Fetch tasks when the component mounts
  useEffect(() => {
    const loadTasks = async () => {
      try {
        const userTasks = await fetchTasksForUser(userId);
        setTasks(userTasks);
      } catch (err) {
        setError(err.message);
      }
    };
    loadTasks();
  }, [userId]);

  // Handle task completion
  const handleTaskCompletion = async (taskId) => {
    try {
      const updatedTask = await markTaskAsCompleted(taskId);
      setTasks((prevTasks) =>
        prevTasks.map((task) => (task.id === updatedTask.id ? updatedTask : task))
      );
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div>
      <h2>Tasks for User {userId}</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            <label>
              <input
                type="checkbox"
                checked={task.status === "COMPLETED"}
                onChange={() => handleTaskCompletion(task.id)}
                disabled={task.status === "COMPLETED"} // Prevent re-checking
              />
              {task.title} - {task.status}
            </label>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TaskList;
