import React, { useState, useEffect } from "react";
import { fetchTasksForUser, markTaskAsCompleted, addTaskForUser ,TaskUpdate} from "../services/api";
import TaskManager from "./TaskManger";
import DataTable from "./DataTable"
import AddTaskForm from "./AddTaskForm";
import { useLocation } from "react-router-dom";


const TaskList = () => {
  const [tasks, setTasks] = useState([]);
  const [error, setError] = useState("");
  const location = useLocation();
  const { userId } = location.state || {}; 

  // Fetch tasks when the component mounts
  useEffect(() => {
    const loadTasks = async () => {
      try {
        const userTasks = await fetchTasksForUser(userId);
        console.log(userTasks)
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

  const handleTaskUpdate =  async (taskId, setTasks) => {
    try {
      const updatedTask = await TaskUpdate(taskId, setTasks);
      setTasks((prevTasks) =>
        prevTasks.map((task) => (task.id === updatedTask.id ? updatedTask : task))
      );
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div>
      {/* <TaskManager
        userId={userId}
        tasks={tasks}
        error={error}
        handleTaskCompletion={handleTaskCompletion}
        handleAdd
        Task={handleAddTask}
      /> */}

      <AddTaskForm
      userId={userId}
      tasks={tasks}
      error={error}
      handleAddTask={handleAddTask}/>
      <DataTable
      tasks={tasks}
      handleTaskCompletion={handleTaskCompletion}
      handleTaskUpdate={handleTaskUpdate}
      setTasks={setTasks} 
      />
      
      

    </div>
  );
};

export default TaskList;
