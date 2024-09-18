package com.Mighty.Performance.controller;

import com.Mighty.Performance.dto.UserDto;
import com.Mighty.Performance.entity.Employee;
import com.Mighty.Performance.repository.EmployeeRepository;
import com.Mighty.Performance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    EmployeeRepository employeeRepository;



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
    @GetMapping("user-page")
    public String userPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "user";
    }

    @GetMapping("admin-page")
    public String adminPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "/sneat-1.0.0/html/index";
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
