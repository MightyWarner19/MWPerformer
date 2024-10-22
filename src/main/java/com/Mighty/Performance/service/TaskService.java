package com.Mighty.Performance.service;

import com.Mighty.Performance.dto.TaskDto;
import java.util.List;
import java.util.Optional;

public interface TaskService {

    // Fetch all tasks as DTOs
    List<TaskDto> getAllTasks();

    // Fetch a specific task by ID
    Optional<TaskDto> getTaskById(Long taskId);

    // Save a new task and return the saved DTO
    void saveTask(TaskDto taskDto);

    // Update an existing task and return the updated DTO
    void updateTask(TaskDto taskDto);

    // Delete a task by ID
    void deleteTask(Long taskId);

    List<TaskDto> getTasksByEmployeeEmail(String empEmail);


}
