package com.Mighty.Performance.controller;


import com.Mighty.Performance.entity.Task;
import com.Mighty.Performance.response.ResponseHandler;
import com.Mighty.Performance.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskAssign {
    TaskService taskService;

    public TaskAssign(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{taskTittle}")
    public ResponseEntity<Object> getTaskDetails(@PathVariable("taskTittle") String taskTittle) {

        return ResponseHandler.responseBuilder("Here is the all details", HttpStatus.OK,taskService.getTask(taskTittle));
    }

    @GetMapping()
    public List<Task> getAllTaskDetails() {
        return taskService.getAllTask();
    }

    @PostMapping
    public String createTaskDetails(@RequestBody Task task){
        taskService.createTask(task);
        return "Task details added successfully";
    }

    @PutMapping
    public String updateTaskDetails(@RequestBody Task task){
        taskService.updateTask(task);
        return "Employee details updated successfully";
    }

    @DeleteMapping("{taskTittle}")
    public String deleteTaskDetails(@PathVariable("taskTittle") String taskTittle) {
        taskService.deleteTask(taskTittle);
        return "Employee details deleted successfully";
    }
}
