import React, { useState } from "react";


const TaskManager = ({ userId, tasks, error, handleTaskCompletion, handleAddTask }) => {
  const [newTask, setNewTask] = useState({
    title: "",
    description: "",
    addedDate: "",
    completionDate: "",
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewTask({ ...newTask, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    handleAddTask(newTask);
    setNewTask({
      title: "",
      description: "",
      addedDate: "",
      completionDate: "",
    });
  };

  return (
    <div>
      <h2>Tasks for User {userId}</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}

      {/* Add Task Form */}
      <form onSubmit={handleSubmit} style={{ marginBottom: "20px" }}>
        <h3>Add a New Task</h3>
        <div>
          <label>
            Title:
            <input
              type="text"
              name="title"
              value={newTask.title}
              onChange={handleInputChange}
              required
            />
          </label>
        </div>
        <div>
          <label>
            Description:
            <input
              type="text"
              name="description"
              value={newTask.description}
              onChange={handleInputChange}
            />
          </label>
        </div>
        <div>
          <label>
            Added Date:
            <input
              type="date"
              name="addedDate"
              value={newTask.addedDate}
              onChange={handleInputChange}
            />
          </label>
        </div>
        <div>
          <label>
            Completion Date:
            <input
              type="date"
              name="completionDate"
              value={newTask.completionDate}
              onChange={handleInputChange}
              required
            />
          </label>
        </div>
        <button type="submit">Add Task</button>
      </form>

      {/* Task Table */}
      <table border="1" style={{ width: "100%", textAlign: "left", borderCollapse: "collapse" }}>
        <thead>
          <tr>
            <th>#</th>
            <th>Title</th>
            <th>Description</th>
            <th>Status</th>
            <th>Added Date</th>
            <th>Completion Date</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map((task, index) => (
            <tr key={task.id}>
              <td>{index + 1}</td>
              <td>{task.title}</td>
              <td>{task.description || "N/A"}</td>
              <td>{task.status}</td>
              <td>{task.addedDate }</td>
              <td>{task.completionDate || "N/A"}</td>
              <td>
                <input
                  type="checkbox"
                  checked={task.status === "COMPLETED"}
                  onChange={() => handleTaskCompletion(task.id)}
                  disabled={task.status === "COMPLETED"} // Prevent re-checking
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>

    
  );
  
};



export default TaskManager;
