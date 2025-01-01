package com.katdev.accountabilityapp.mapper;

import com.katdev.accountabilityapp.DataTransfer.TaskDTO;
import com.katdev.accountabilityapp.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public static TaskDTO toDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setAddedDate(task.getAddedDate());
        taskDTO.setCompletionDate(task.getCompletionDate());
        taskDTO.setPoints(task.getPoints());
        return taskDTO;
    }

    public static Task toEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setAddedDate(taskDTO.getAddedDate());
        task.setCompletionDate(taskDTO.getCompletionDate());
        task.setPoints(taskDTO.getPoints());
        return task;
    }
}
