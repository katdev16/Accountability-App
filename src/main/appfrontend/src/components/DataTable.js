import * as React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import Paper from '@mui/material/Paper';

export default function TaskTable({ tasks = [], handleTaskCompletion ,handleTaskUpdate}) {
  // Ensure rows are properly formatted
 
  const rows = tasks.map((task, index) => ({
    id: task.id, // Ensure this is unique for the DataGrid
    title: task.title,
    description: task.description || "N/A",
    status: task.status,
    addedDate: task.addedDate || "N/A",
    completionDate: task.completionDate || "N/A",
  }));

  const columns = [
    { field: 'id', headerName: '#', width: 70 },
    { field: 'title', headerName: 'Title', width: 150 , editable: true},
    { field: 'description', headerName: 'Description', width: 200 , editable: true},
    { field: 'status', headerName: 'Status', width: 120 },
    { field: 'addedDate', headerName: 'Added Date', width: 150 },
    { field: 'completionDate', headerName: 'Completion Date', width: 150 , editable: true},
    {
      field: 'actions',
      headerName: 'Actions',
      width: 120,
      renderCell: (params) => (
        <input
          type="checkbox"
          checked={params.row.status === 'COMPLETED'}
          
          onChange={() => handleTaskCompletion(params.row.id)}
          disabled={params.row.status === 'COMPLETED'} // Prevent re-checking
        />
      ),
    },
  ];

  const processRowUpdate = (newRow) => {
    const updatedTask = { ...newRow }; // Updated task data
    handleTaskUpdate(updatedTask); // Call the parent handler
    return updatedTask; // Return the updated row
  };

  return (
    <Paper sx={{ height: 400, width: '100%' }}>
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
