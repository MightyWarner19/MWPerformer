package com.Mighty.Performance.service.Impl;

import com.Mighty.Performance.dto.TaskDto;
import com.Mighty.Performance.entity.Employee;
import com.Mighty.Performance.entity.Task;
import com.Mighty.Performance.entity.Team;
import com.Mighty.Performance.exception.TaskNotFoundException;
import com.Mighty.Performance.repository.EmployeeRepository;
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

    @Autowired
    private EmployeeRepository employeeRepository; // Assuming you have an EmployeeRepository

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TaskDto> getTaskById(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isPresent()) {
            return task.map(this::convertEntityToDto);
        } else {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found");
        }
    }

    @Override
    public void saveTask(TaskDto taskDto) {
        Employee employee = employeeRepository.findByEmpEmail(taskDto.getAssignEmployee())
                .orElseThrow(() -> new TaskNotFoundException("Employee with email " + taskDto.getAssignEmployee() + " not found"));

        Task task = convertDtoToEntity(taskDto);
        task.setAssignEmployee(employee);  // Ensure employee is set properly
        taskRepository.save(task);
    }

    @Override
    public void updateTask(TaskDto taskDto) {
        Employee employee = employeeRepository.findByEmpEmail(taskDto.getAssignEmployee())
                .orElseThrow(() -> new TaskNotFoundException("Employee with email " + taskDto.getAssignEmployee() + " not found"));

        Task task = convertDtoToEntity(taskDto);
        task.setAssignEmployee(employee);  // Ensure employee is set properly
        taskRepository.save(task);
    }


    @Override
    public void deleteTask(Long taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found");
        }
        taskRepository.deleteById(taskId);
    }

    @Override
    public List<TaskDto> getTasksByEmployeeEmail(String empEmail) {
        return taskRepository.findByAssignEmployeeEmpEmail(empEmail)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }


    // Helper methods to convert between Task entity and TaskDto

    // Convert Task entity to TaskDto
    private TaskDto convertEntityToDto(Task task) {
        return new TaskDto(
                task.getTaskId(),
                task.getTaskName(),
                task.getProId(),
                task.getAssignEmployee().getEmpEmail(),  // Extract the email from Employee
                task.getTaskStartDate(),
                task.getTaskEndDate(),
                task.getTaskDescription(),
                task.getTaskStatus() // Don't forget to map the task status
        );
    }

    // Convert TaskDto to Task entity
    private Task convertDtoToEntity(TaskDto taskDto) {
        Employee employee= employeeRepository.findByEmpEmail(taskDto.getAssignEmployee()).orElse(null);

        Task task = new Task();
        task.setTaskId(taskDto.getTaskId());
        task.setTaskName(taskDto.getTaskName());
        task.setProId(taskDto.getProId());
        task.setAssignEmployee(employee);  // Assign the Employee object here
        task.setTaskStartDate(taskDto.getTaskStartDate());
        task.setTaskEndDate(taskDto.getTaskEndDate());
        task.setTaskDescription(taskDto.getTaskDescription());
        task.setTaskStatus(taskDto.getTaskStatus());  // Map the task status
        return task;
    }

}
