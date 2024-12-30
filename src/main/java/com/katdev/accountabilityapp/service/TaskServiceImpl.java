package com.katdev.accountabilityapp.service;

import com.katdev.accountabilityapp.DataTransfer.TaskDTO;
import com.katdev.accountabilityapp.model.Task;
import com.katdev.accountabilityapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Task saveTask(Task task) {
        // Set the addedDate to the current date if it's not already set
        if (task.getAddedDate() == null) {
            task.setAddedDate(LocalDate.now());
        }

        // Validate completionDate
        if (task.getCompletionDate() != null && task.getCompletionDate().isBefore(task.getAddedDate())) {
            throw new RuntimeException("Completion date cannot be before the added date");
        }

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

    @Override
    public Task updateTask(int id, Task updatedTask) {
        // Check if the task exists
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with ID " + id + " not found"));

        // Update task details
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setCompletionDate(updatedTask.getCompletionDate());

        // Save updated task to the database
        return taskRepository.save(existingTask);
    }


    @Override
    public void deleteTaskById(int id) {
        // Check if the task exists
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with ID " + id + " not found"));

        // Delete the task
        taskRepository.delete(existingTask);
    }


    @Override
    public Task markTaskAsCompleted(int id) {
        // Check if the task exists
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with ID " + id + " not found"));

        // Update the status to "Completed"
        existingTask.setStatus("Completed");

        // Save the updated task
        return taskRepository.save(existingTask);
    }


    @Override
    public Task getTaskById(int id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with ID " + id + " not found"));
    }
    @Override
    public List<TaskDTO> getTasksByUserId(int userId) {
        List<Task> tasks = taskRepository.findAll().stream()
                .filter(task -> task.getUser().getId() == userId)
                .collect(Collectors.toList());

        return tasks.stream().map(task -> {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setTitle(task.getTitle());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setStatus(task.getStatus());
            taskDTO.setAddedDate(task.getAddedDate());
            taskDTO.setCompletionDate(task.getCompletionDate());
            taskDTO.setPoints(task.getPoints());
            return taskDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public TaskDTO markTaskAsComplete(int taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus("completed");
        task.setCompletionDate(LocalDate.now()); // Set current date as completion date

        Task updatedTask = taskRepository.save(task);

        // Map to DTO
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(updatedTask.getId());
        taskDTO.setTitle(updatedTask.getTitle());
        taskDTO.setDescription(updatedTask.getDescription());
        taskDTO.setStatus(updatedTask.getStatus());
        taskDTO.setAddedDate(updatedTask.getAddedDate());
        taskDTO.setCompletionDate(updatedTask.getCompletionDate());

        return taskDTO;
    }

}
