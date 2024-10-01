package com.Mighty.Performance.service.Impl;

import com.Mighty.Performance.dto.ProjectDto;
import com.Mighty.Performance.dto.TaskDto;
import com.Mighty.Performance.entity.Project;
import com.Mighty.Performance.entity.Task;
// Assuming there is a TaskNotFoundException
import com.Mighty.Performance.repository.TaskRepository;
import com.Mighty.Performance.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TaskDto> getTaskById(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        return task.map(this::convertEntityToDto);
    }

    @Override
    public void saveTask(TaskDto taskDto) {
        Task task = convertDtoToEntity(taskDto);
        taskRepository.save(task);
    }

    @Override
    public void updateTask(TaskDto taskDto) {
        Task task = convertDtoToEntity(taskDto);
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
       taskRepository.deleteById(taskId);
    }


    // Helper methods to convert between DTO and Entity
    private TaskDto convertEntityToDto(Task task) {
        return new TaskDto(
                task.getTaskId(),
                task.getTaskName(),
                task.getProId(),
                task.getAssignEmployee(),
                task.getTaskStartDate(),
                task.getTaskEndDate(),
                task.getTaskDescription()
        );
    }

    private Task convertDtoToEntity(TaskDto taskDto) {
        return new Task(
                taskDto.getTaskId(),
                taskDto.getTaskName(),
                taskDto.getProId(),
                taskDto.getAssignEmployee(),
                taskDto.getTaskStartDate(),
                taskDto.getTaskEndDate(),
                taskDto.getTaskDescription()
        );
    }
}
