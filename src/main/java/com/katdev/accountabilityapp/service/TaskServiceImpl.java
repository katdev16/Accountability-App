package com.katdev.accountabilityapp.service;

import com.katdev.accountabilityapp.model.Task;
import com.katdev.accountabilityapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }


    @Override
    public String deletetask(Task task) {
        taskRepository.delete(task);
        return "Task deleted";
    }
    @Override
    public Task updateTaskStatus(int taskId, String status) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
        task.setStatus(status);
        return taskRepository.save(task);
    }
}
