package com.katdev.accountabilityapp.controller;

import com.katdev.accountabilityapp.model.Task;
import com.katdev.accountabilityapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Endpoint to save a new task
    @PostMapping
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateTaskStatus(
            @PathVariable int id,
            @RequestParam String status) {
        Task updatedTask = taskService.updateTaskStatus(id, status);
        return ResponseEntity.ok(updatedTask);
    }


    // Endpoint to get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTask();
    }

    // Endpoint to delete a task
    @DeleteMapping
    public String deleteTask(@RequestBody Task task) {
        return taskService.deletetask(task);
    }
}
