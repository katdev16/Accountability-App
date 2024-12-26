import { AddTask } from "@mui/icons-material"

export default function AddTaskForm(){
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
}
