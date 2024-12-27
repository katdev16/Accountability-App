import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import Register from "./components/Register";
import AppBar from "./components/AppBar";
import TaskList from "./components/TaskList";

const App = () => {
  return (
    <Router>
      <div>
        <AppBar/>
        <h1>Accountability App</h1>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/Home" element={<TaskList />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
