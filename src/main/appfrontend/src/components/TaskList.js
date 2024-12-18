import React, { useState, useEffect } from "react";
import { fetchTasksForUser, markTaskAsCompleted, addTaskForUser } from "../services/api";
import TaskManager from "./TaskManger";

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

  // Handle adding a new task
  const handleAddTask = async (newTask) => {
    try {
      const createdTask = await addTaskForUser(userId, newTask);
      setTasks((prevTasks) => [...prevTasks, createdTask]);
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div>
      <TaskManager
        userId={userId}
        tasks={tasks}
        error={error}
        handleTaskCompletion={handleTaskCompletion}
        handleAddTask={handleAddTask}
      />
    </div>
  );
};

export default TaskList;
