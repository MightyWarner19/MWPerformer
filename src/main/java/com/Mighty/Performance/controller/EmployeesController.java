package com.Mighty.Performance.controller;

import com.Mighty.Performance.dto.EmployeeDto;
import com.Mighty.Performance.entity.Employee;
import com.Mighty.Performance.repository.EmployeeRepository;
import com.Mighty.Performance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;


@Controller
//@RequestMapping("")
public class EmployeesController {


//    public EmployeesController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//    @GetMapping("/{empId}")
//    public ResponseEntity<Object> getEmployeeDetails(@PathVariable("empId") String empId) {
//
//        return ResponseHandler.responseBuilder("Here is the all details", HttpStatus.OK,employeeService.getEmployee(empId));
//    }
//
//    @GetMapping()
//    public List<Employee> getAllEmployeeDetails() {
//        return employeeService.getAllEmployees();
//    }
//
//    @PostMapping
//    public String createEmployeeDetails(@RequestBody  Employee employee){
//        employeeService.createEmployee(employee);
//        return "Employee details added successfully";
//    }
//
//    @PutMapping
//    public String updateEmployeeDetails(@RequestBody  Employee employee){
//        employeeService.updateEmployee(employee);
//        return "Employee details updated successfully";
//    }
//
//    @DeleteMapping("{empId}")
//    public String deleteEmployeeDetails(@PathVariable("empId") String empId) {
//        employeeService.deleteEmployee(empId);
//        return "Employee details deleted successfully";
////    }

//    last code from here
//private EmployeeService employeeService;
//
//    @Autowired
//    public void EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//    @Autowired
//    UserDetailsService userDetailsService;
//
//    @Autowired
//    EmployeeRepository employeeRepository;
//
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
//
//        // Check if employee already exists (for edit)
//        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getEmpId());
//        if (existingEmployee.isPresent()) {
//            Employee updatedEmployee = existingEmployee.get();
//            updatedEmployee.setEmpName(employee.getEmpName());
//            updatedEmployee.setEmpEmail(employee.getEmpEmail());
//            updatedEmployee.setEmpPhone(employee.getEmpPhone());
//            updatedEmployee.setEmpProfile(employee.getEmpProfile());
//            updatedEmployee.setProId(employee.getProId());
//            updatedEmployee.setTeamId(employee.getTeamId());
//            employeeRepository.save(updatedEmployee); // Save updated employee
//        } else {
//            employeeRepository.save(employee); // Save new employee
//        }
//        model.addAttribute("employees", employeeRepository.findAll());
//        model.addAttribute("employee", new Employee());// Reload the page to show the updated list of items
//
//
//        // Redirecting back to the employees page
//        return "redirect:/admin-page/employees"; // Redirect to avoid form resubmission;
//    }
//    @PostMapping("/admin-page/employees/delete")
//    public String deleteEmployee(@RequestParam("id") String empId) {
//        employeeService.deleteEmployeeById(empId);
//        return "redirect:/admin-page/employees";  // Redirect to employee list after delete
//    }

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    public void EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("admin-page/teams")
    public String teamPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "/sneat-1.0.0/html/teams";
    }

    @GetMapping("admin-page/employees")
    public String employeePage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        model.addAttribute("employee", new EmployeeDto());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "/sneat-1.0.0/html/employee";
    }

    @PostMapping("admin-page/employees")
    public String addOrUpdateEmployee(@ModelAttribute EmployeeDto employeeDto, Model model, Principal principal) {
        employeeService.saveEmployee(employeeDto);
        return "redirect:/admin-page/employees";
    }

    @PostMapping("admin-page/employees/delete")
    public String deleteEmployee(@RequestParam("id") String empId) {
        employeeService.deleteEmployee(empId);  // Implement deletion logic here
        return "redirect:/admin-page/employees";
    }

}
