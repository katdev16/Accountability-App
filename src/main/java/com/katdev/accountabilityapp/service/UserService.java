package com.katdev.accountabilityapp.service;

import com.katdev.accountabilityapp.DataTransfer.UserDTO;
import com.katdev.accountabilityapp.DataTransfer.TaskDTO;
import com.katdev.accountabilityapp.model.Task;
import com.katdev.accountabilityapp.model.User;
import com.katdev.accountabilityapp.repository.UserRepository;
import com.katdev.accountabilityapp.repository.TaskRepository;
import com.katdev.accountabilityapp.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    // Fetch a user by ID, return as UserDTO with tasks
    public UserDTO getUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Mapping user entity to user DTO
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        // Map tasks to TaskDTO
        List<TaskDTO> taskDTOs = user.getTasks().stream().map(task -> {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setTitle(task.getTitle());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setStatus(task.getStatus());
            taskDTO.setAddedDate(task.getAddedDate());
            taskDTO.setCompletionDate(task.getCompletionDate());
            return taskDTO;
        }).collect(Collectors.toList());

        userDTO.setTasks(taskDTOs);

        return userDTO;
    }

    // Fetch all users as UserDTO list
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());

            List<TaskDTO> taskDTOs = user.getTasks().stream().map(task -> {
                TaskDTO taskDTO = new TaskDTO();
                taskDTO.setId(task.getId());
                taskDTO.setTitle(task.getTitle());
                taskDTO.setDescription(task.getDescription());
                taskDTO.setStatus(task.getStatus());
                taskDTO.setAddedDate(task.getAddedDate());
                taskDTO.setCompletionDate(task.getCompletionDate());
                return taskDTO;
            }).collect(Collectors.toList());

            userDTO.setTasks(taskDTOs);

            return userDTO;
        }).collect(Collectors.toList());
    }

    // Create a new user


    public UserDTO createUser(User user) {
//        // Hash the password before saving the user
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user
        User savedUser = userRepository.save(user);

        // Map the saved user to a UserDTO
        UserDTO userDTO = new UserDTO();
        userDTO.setId(savedUser.getId());
        userDTO.setName(savedUser.getName());
        userDTO.setEmail(savedUser.getEmail());
//        userDTO.setPoints(savedUser.);
        // Note: Password is excluded from the UserDTO for security reasons

        return userDTO;
    }

    // Update user details by ID
    public UserDTO updateUser(int id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());

        User updated = userRepository.save(existingUser);

        // Mapping updated user to UserDTO
        UserDTO userDTO = new UserDTO();
        userDTO.setId(updated.getId());
        userDTO.setName(updated.getName());
        userDTO.setEmail(updated.getEmail());

        return userDTO;
    }

    // Delete user by ID
    public String deleteUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);

        return "User deleted successfully";
    }

    // Method to assign a task to a user (optional)
    public void assignTaskToUser(int userId, int taskId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setUser(user);
        taskRepository.save(task);
    }

    // In UserServiceImpl.java

    public TaskDTO createTaskForUser(int userId, TaskDTO taskDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (taskDTO.getAddedDate() == null ) {
            taskDTO.setAddedDate(LocalDate.now()); // Format as String (e.g., "2024-12-17")
        }
        if (taskDTO.getStatus() == null ) {
            taskDTO.setStatus("pending"); // Format as String (e.g., "2024-12-17")
        }


        // Convert DTO to Entity
        Task task = TaskMapper.toEntity(taskDTO);
        task.setUser(user);

        // Save the Task
        Task savedTask = taskRepository.save(task);

        // Convert saved entity to DTO and return
        return TaskMapper.toDTO(savedTask);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public List<TaskDTO> getTasksForUser(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Task> tasks = user.getTasks();

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

}
