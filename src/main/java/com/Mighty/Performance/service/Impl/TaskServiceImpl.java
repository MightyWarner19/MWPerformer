package com.Mighty.Performance.service.Impl;

import com.Mighty.Performance.exception.EmployeeNotFoundException;
import com.Mighty.Performance.entity.Task;
import com.Mighty.Performance.repository.TaskRepository;
import com.Mighty.Performance.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public String createTask(Task task) {
        taskRepository.save(task);
        return "Success";
    }

    @Override
    public String updateTask(Task task) {
        taskRepository.save(task);
        return "Success";
    }

    @Override
    public String deleteTask(String taskTittle) {
        taskRepository.deleteById(taskTittle);
        return "Success";
    }

    @Override
    public Task getTask(String taskTittle) {
        if (taskRepository.findById(taskTittle).isEmpty())
            throw new EmployeeNotFoundException("Requested Task does not exist");
        return taskRepository.findById(taskTittle).get();
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }
}
