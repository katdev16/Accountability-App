package com.katdev.accountabilityapp.service;

import com.katdev.accountabilityapp.model.Task;

import java.util.List;

public interface TaskService {
    public Task saveTask(Task task);
    public List<Task> getAllTask();
    public String deletetask(Task task);

//    String deletetask(Task task);
}