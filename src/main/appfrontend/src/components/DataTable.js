import * as React from "react";
import { DataGrid } from "@mui/x-data-grid";
import Paper from "@mui/material/Paper";
import DeleteIcon from "@mui/icons-material/Delete";
import { TaskUpdate ,deleteTask} from "../services/api";

export default function TaskTable({
  tasks = [],
  handleTaskCompletion,
  handleTaskUpdate,
  setTasks,
}) {
  // Format rows for the DataGrid
  const rows = tasks.map((task) => ({
    id: task.id, // Ensure this is unique for the DataGrid
    title: task.title,
    description: task.description || "N/A",
    status: task.status,
    addedDate: task.addedDate || "N/A",
    completionDate: task.completionDate || "N/A",
  }));

  // Define columns
  const columns = [
    { field: "id", headerName: "#", width: 70 },
    { field: "title", headerName: "Title", width: 150, editable: true },
    { field: "description", headerName: "Description", width: 200, editable: true },
    { field: "status", headerName: "Status", width: 120 },
    { field: "addedDate", headerName: "Added Date", width: 150 },
    { field: "completionDate", headerName: "Completion Date", width: 150, editable: true },
    {
      field: "actions",
      headerName: "Actions",
      width: 120,
      renderCell: (params) => (
        <input
          type="checkbox"
          checked={params.row.status === "COMPLETED"}
          onChange={() => handleTaskCompletion(params.row.id)}
          disabled={params.row.status === "COMPLETED"} // Prevent re-checking
        />
      ),
    },
    {
      field: "delete",
      headerName: "Delete",
      width: 100,
      renderCell: (params) => (
        <DeleteIcon
          data-testid="DeleteIcon"
          style={{ cursor: "pointer", color: "red" }}
          onClick={() => handleDelete(params.row.id)}
        />
      ),
    },
  ];


  // Handle row deletion
  const handleDelete = async (taskId) => {
    if (window.confirm("Are you sure you want to delete this task?")) {
      try {
        // Make API call to delete the task
        await deleteTask(taskId);

        // Remove the task from the local state
        setTasks((prevTasks) => prevTasks.filter((task) => task.id !== taskId));
        alert("Task deleted successfully!");
      } catch (error) {
        console.error("Error deleting task:", error);
        alert("Failed to delete task. Please try again.");
      }
    }
  };

  // Function for handling row updates in the DataGrid
  const processRowUpdate = async (newRow) => {
    console.log("Updated row:", newRow); // Debug the updated row data
    const updatedTask = { ...newRow };
    await TaskUpdate(updatedTask, setTasks); // Pass setTasks correctly
    return updatedTask; // Return updated row
  };

  return (
    <Paper sx={{ height: 400, width: "100%" }}>
      <DataGrid
        rows={rows}
        columns={columns}
        pageSizeOptions={[5, 10]}
        checkboxSelection={false} // We handle selection with the "Actions" column
        disableRowSelectionOnClick
        sx={{ border: 0 }}
        processRowUpdate={processRowUpdate} // Handles edits
        experimentalFeatures={{ newEditingApi: true }} // Enable new editing API
      />
    </Paper>
  );
}
