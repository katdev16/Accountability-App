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
//    @PostMapping
//    public Task saveTask(@RequestBody Task task) {
//        return taskService.saveTask(task);
//    }
//    @PutMapping("/{id}/status")
//    public ResponseEntity<Task> updateTaskStatus(
//            @PathVariable int id,
//            @RequestParam String status) {
//        Task updatedTask = taskService.updateTaskStatus(id, status);
//        return ResponseEntity.ok(updatedTask);
//    }


    // Endpoint to get all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    // Endpoint to delete a task
//    @DeleteMapping
//    public String deleteTask(@RequestBody Task task) {
//        return taskService.deletetask(task);
//    }

    // 3. Get a task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        Task task = taskService.getTaskById(id); // Add getTaskById in the service
        return ResponseEntity.ok(task);
    }

    // 4. Update an existing task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        Task task = taskService.updateTask(id, updatedTask); // Add updateTask in the service
        return ResponseEntity.ok(task);
    }

    // 5. Mark a task as completed
    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> changeTaskStatus(@PathVariable int id) {
        Task task = taskService.markTaskAsCompleted(id); // Add markTaskAsCompleted in the service
        return ResponseEntity.ok(task);
    }

    // 6. Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        taskService.deleteTaskById(id); // Add deleteTaskById in the service
        return ResponseEntity.ok("Task with ID " + id + " deleted successfully");
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return ResponseEntity.ok(savedTask);
    }


}
