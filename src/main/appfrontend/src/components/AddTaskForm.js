import { AddTask } from "@mui/icons-material"
import * as React from 'react';

export default function AddTaskForm({ userId, tasks, error, handleTaskCompletion, handleAddTask }){
      const [newTask, setNewTask] =  React.useState({
        title: "",
        description: "",
        addedDate: "",
        completionDate: "",
        points: 0,
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
          points: 0,
        });
      };
    
       
        return(
       <div>
         <h2>Tasks for User {userId}</h2>
         {error && <p style={{ color: "red" }}>{error}</p>}
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
            <div>
          <label>
            Points:
            <select
              name="points"
              value={newTask.points}
              onChange={handleInputChange}
              required
            >
              <option value={1}>1</option>
              <option value={3}>3</option>
              <option value={5}>5</option>
            </select>
          </label>
        </div>
            <button type="submit">Add Task</button>
        </form></div>)
    
}
