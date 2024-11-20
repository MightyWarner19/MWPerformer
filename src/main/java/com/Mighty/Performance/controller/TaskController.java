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
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/admin-page/tasks")
    public String taskPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        model.addAttribute("employee", new EmployeeDto());
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("task", new TaskDto());
        model.addAttribute("tasks", taskService.getAllTasks());
        return "sneat-1.0.0/html/tasks";
    }

    @PostMapping("/admin-page/tasks")
    public String addOrUpdateTask(@ModelAttribute TaskDto taskDto, Model model, Principal principal) {
        taskService.saveTask(taskDto);
        return "redirect:/admin-page/tasks";
    }

    @PostMapping("/admin-page/tasks/delete")
    public String deleteTask(@RequestParam("id") Long taskId) {
        taskService.deleteTask(taskId);  // Implement deletion logic here
        return "redirect:/admin-page/tasks";
    }

    @GetMapping("/admin-page/employees/{empId}")
    public String getEmployeeProfile(
            @PathVariable("empId") String empId,
            Model model,
            Principal principal) {

        // Load authenticated user details
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);

        // Replace "-" with "/" if needed
        empId = empId.replace("-", "/");

        // Fetch employee details using empId
        Optional<EmployeeDto> employee = employeeService.getEmployeeById(empId);
        if (employee.isEmpty()) {
            return "error/404";  // Handle missing employee
        }

        // Get the employee's email
        String empEmail = employee.get().getEmpEmail();

        // Fetch tasks associated with this employee's email
        List<TaskDto> tasks = taskService.getTasksByEmployeeEmail(empEmail);

        // Add employee and tasks to the model
        model.addAttribute("employee", employee.get());
        model.addAttribute("tasks", tasks);

        // Return the profile view
        return "sneat-1.0.0/html/profile";
    }

    @GetMapping("/admin-page/employees/{empId}/performance")
    public String getEmployeePerformance(
            @PathVariable("empId") String empId,
            Model model,
            Principal principal) {

        // Load authenticated user details
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);

        // Replace "-" with "/" if needed
        empId = empId.replace("-", "/");

        // Fetch employee details using empId
        Optional<EmployeeDto> employee = employeeService.getEmployeeById(empId);
        if (employee.isEmpty()) {
            return "error/404";  // Handle missing employee
        }

        // Get the employee's email
        String empEmail = employee.get().getEmpEmail();

        // Fetch tasks associated with this employee's email
        List<TaskDto> tasks = taskService.getTasksByEmployeeEmail(empEmail);

        // Add employee and tasks to the model
        model.addAttribute("employee", employee.get());
        model.addAttribute("tasks", tasks);

        // Return the profile view
        return "sneat-1.0.0/html/performance";
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
