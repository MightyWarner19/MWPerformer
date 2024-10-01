package com.Mighty.Performance.controller;


import com.Mighty.Performance.dto.EmployeeDto;
import com.Mighty.Performance.dto.ProjectDto;
import com.Mighty.Performance.dto.TaskDto;
import com.Mighty.Performance.service.EmployeeService;
import com.Mighty.Performance.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class TaskController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaskService taskService;
    @Autowired
    public void EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("admin-page/tasks")
    public String employeePage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        model.addAttribute("employee", new EmployeeDto());
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("task", new TaskDto());
        model.addAttribute("tasks", taskService.getAllTasks());
        return "/sneat-1.0.0/html/tasks";
    }

    @PostMapping("/admin-page/tasks")
    public String addOrUpdateTask(@ModelAttribute TaskDto taskDto, Model model, Principal principal) {
        taskService.saveTask(taskDto);
        return "redirect:/admin-page/tasks";
    }
//    TaskService taskService;
//
//    public TaskAssign(TaskService taskService) {
//        this.taskService = taskService;
//    }
//
//    @GetMapping("/{taskTittle}")
//    public ResponseEntity<Object> getTaskDetails(@PathVariable("taskTittle") String taskTittle) {
//
//        return ResponseHandler.responseBuilder("Here is the all details", HttpStatus.OK,taskService.getTask(taskTittle));
//    }
//
//    @GetMapping()
//    public List<Task> getAllTaskDetails() {
//        return taskService.getAllTask();
//    }
//
//    @PostMapping
//    public String createTaskDetails(@RequestBody Task task){
//        taskService.createTask(task);
//        return "Task details added successfully";
//    }
//
//    @PutMapping
//    public String updateTaskDetails(@RequestBody Task task){
//        taskService.updateTask(task);
//        return "Employee details updated successfully";
//    }
//
//    @DeleteMapping("{taskTittle}")
//    public String deleteTaskDetails(@PathVariable("taskTittle") String taskTittle) {
//        taskService.deleteTask(taskTittle);
//        return "Employee details deleted successfully";
//    }
}
