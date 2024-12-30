package com.katdev.accountabilityapp.DataTransfer;

import com.katdev.accountabilityapp.model.Task;

import java.util.List;

public class UserDTO {
    private int id;
    private String name;
    private String email;
    private List<TaskDTO> tasks;
    private int points;

    // Getters and setters...

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

