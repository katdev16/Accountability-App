package com.katdev.accountabilityapp.service;

import com.katdev.accountabilityapp.model.Task;

import java.util.List;

public interface TaskService {
    public Task saveTask(Task task);
    public List<Task> getAllTask();
    public String deletetask(Task task);
    Task updateTaskStatus(int taskId, String status);

    Task updateTask(int id, Task updatedTask);

    void deleteTaskById(int id);

    Task markTaskAsCompleted(int id);

    Task getTaskById(int id);

//    String deletetask(Task task);
}
