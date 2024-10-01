package com.Mighty.Performance.service;



import com.Mighty.Performance.dto.TaskDto;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<TaskDto> getAllTasks();
    Optional<TaskDto> getTaskById(Long taskId);
    void saveTask(TaskDto taskDto);
    void updateTask(TaskDto taskDto);
    void deleteTask(Long taskId);
}
