package com.Mighty.Performance.controller;

import com.Mighty.Performance.dto.EmployeeDto;
import com.Mighty.Performance.dto.ProjectDto;
import com.Mighty.Performance.dto.UserDto;
import com.Mighty.Performance.entity.Employee;
import com.Mighty.Performance.repository.EmployeeRepository;
import com.Mighty.Performance.service.EmployeeService;
import com.Mighty.Performance.service.ProjectService;
import com.Mighty.Performance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/")
    public String mainPage() {
        return "/sneat-1.0.0/html/pages-misc-error";
    }

    @GetMapping("/login")
    public String login() {
        return "/sneat-1.0.0/html/auth-login-basic";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "/sneat-1.0.0/html/auth-register-basic";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        userService.save(userDto);
        model.addAttribute("message", "Registered Successfuly!");
        return "/sneat-1.0.0/html/auth-register-basic";
    }
//    @GetMapping("/admin-page/employees/profile")
//    public String userPage (Model model, Principal principal) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//        model.addAttribute("user", userDetails);
//        return "/sneat-1.0.0/html/profile";
//    }

    @GetMapping("/admin-page/employees/profile/{empId}")
    public String getEmployeeProfile(@PathVariable("empId") String empId, Model model, Principal principal) {
        // Load authenticated user details
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);

        empId = empId.replace("-", "/");
        // Fetch employee details by empId
        Optional<EmployeeDto> employee = employeeService.getEmployeeById(empId);

        // Check if employee exists
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        } else {
            // Handle the case where the employee isn't found
            return "error/404"; // Display a 404 page or return another error view
        }

        // Return the correct Thymeleaf template
        return "sneat-1.0.0/html/profile";
    }


    @GetMapping("/admin-page")
    public String adminPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        model.addAttribute("project", new ProjectDto());
        model.addAttribute("projects", projectService.getAllProjects());
        return "/sneat-1.0.0/html/index";
    }


    @PostMapping("/admin-page")
    public String addOrUpdateProject(@ModelAttribute ProjectDto projectDto, Model model, Principal principal) {
       projectService.saveProject(projectDto);
        return "redirect:/admin-page";
    }

    @PostMapping("/admin-page/delete")
    public String deleteProject(@RequestParam("id") String proId) {
        projectService.deleteProject(proId);  // Implement deletion logic here
        return "redirect:/admin-page";
    }
//    @GetMapping("admin-page/employees")
//    public String employeePage(Model model, Principal principal) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//        model.addAttribute("user", userDetails);
//        model.addAttribute("employee", new Employee());
//        model.addAttribute("employees", employeeRepository.findAll());
//        return "/sneat-1.0.0/html/employee";
//    }
//
//    @PostMapping("admin-page/employees")
//    public String addItem(@ModelAttribute Employee employee, Model model, Principal principal) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//        model.addAttribute("user", userDetails);
//        employeeRepository.save(employee);
//        model.addAttribute("employees", employeeRepository.findAll());
//        model.addAttribute("employee", new Employee());// Reload the page to show the updated list of items
//        return "/sneat-1.0.0/html/employee";
//    }
}
