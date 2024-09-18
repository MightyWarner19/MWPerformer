package com.Mighty.Performance.service;



import com.Mighty.Performance.entity.Task;

import java.util.List;

public interface TaskService {
    public String createTask(Task task);
    public String updateTask(Task task);
    public String deleteTask(String taskTittle);
    public Task getTask(String taskTittle);
    public List<Task> getAllTask();
}
