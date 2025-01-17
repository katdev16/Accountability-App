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
    priority: task.priority ,
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
    { field: "priority", headerName: "Priority", width: 100},
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


  const handleDelete = async (taskId) => {
    if (window.confirm("Are you sure you want to delete this task?")) {
      try {
        
        await deleteTask(taskId);

        
        setTasks((prevTasks) => prevTasks.filter((task) => task.id !== taskId));
        alert("Task deleted successfully!");
      } catch (error) {
        console.error("Error deleting task:", error);
        alert("Failed to delete task. Please try again.");
      }
    }
  };

  
  const processRowUpdate = async (newRow) => {
    console.log("Updated row:", newRow); // Debug the updated row data
    const updatedTask = { ...newRow };
    await TaskUpdate(updatedTask, setTasks); // Pass setTasks correctly
    return updatedTask; 
  };


const getCompletedPointsPercentage = () => {
  const completedTasks = tasks.filter((task) => task.status === "completed");
  const completedPoints = completedTasks.reduce((sum, task) => sum + task.points, 0);
  const totalPoints = tasks.reduce((sum, task) => sum + task.points, 0);
  
  if (totalPoints === 0) return 0; // Avoid division by zero
  return ((completedPoints / totalPoints) * 100).toFixed(2); // Return percentage with 2 decimal places
};

const getScoreFromStatus = () => {
  const completedTasks = tasks.filter((task) => task.status === "completed");
  console.log('completed')
  console.log(completedTasks);
  const incompleteTasks = tasks.filter((task) => task.status !== "completed");
  console.log("incompleted")
  console.log(incompleteTasks);

  // Calculate points for completed and incomplete tasks
  const completedPoints = completedTasks.reduce((sum, task) => sum + task.points, 0);
  const incompletePoints = incompleteTasks.reduce((sum, task) => sum + task.points, 0);

  // Total points available
  // const totalPoints = tasks.reduce((sum, task) => sum + task.points, 0);

  const totalPoints = completedPoints + incompletePoints;

  // Calculate score as (Completed Points - Incomplete Points) / Total Points * 100
  if (totalPoints === 0) return 0; // Avoid division by zero
  return (((completedPoints - incompletePoints) / totalPoints) * 100).toFixed(2); // Return percentage
};



  return (
    <>
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
      <div style={{ marginTop: "20px", textAlign: "center" }}>
      <strong> Task Completion Percentage: </strong>
      {getScoreFromStatus()}%
    </div>
    </>
  );
}
