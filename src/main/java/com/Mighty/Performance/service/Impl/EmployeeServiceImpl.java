package com.Mighty.Performance.service.Impl;

import com.Mighty.Performance.entity.Employee;
import com.Mighty.Performance.repository.EmployeeRepository;
import com.Mighty.Performance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {



    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void deleteEmployeeById(String empId) {
        employeeRepository.deleteById(empId);
    }


//    // Add a new employee
//    @Override
//    public void addEmployee(Employee employee) {
//        employeeRepository.save(employee);
//    }
//
//    // Update an existing employee
//    @Override
//    public void updateEmployee(Employee employee) {
//        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getEmpId());
//        if (existingEmployee.isPresent()) {
//            employeeRepository.save(employee);  // Save updated employee
//        }
//    }
//
//    @Override
//    public Optional<Employee> findEmployeeById(String empId) {
//        return employeeRepository.findById(empId);
//    }
//
//    // Get all employees
//    @Override
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }

//    @Override
//    public String createEmployee(Employee employee) {
//        employeeRepository.save(employee);
//        return "Success";
//    }
//
//    @Override
//    public String updateEmployee(Employee employee) {
//        employeeRepository.save(employee);
//        return "Success";
//    }
//
//    @Override
//    public String deleteEmployee(String empId) {
//        employeeRepository.deleteById(empId);
//        return "deleted!";
//
//
//    @Override
//    public Employee getEmployee(String empId) {
//        if (employeeRepository.findById(empId).isEmpty())
//            throw new EmployeeNotFoundException("Requested Employee does not exist");
//        return employeeRepository.findById(empId).get();
//    }
//
//    @Override
//    public List<Employee> getAllEmployees() {
////        return List.of();
//        return employeeRepository.findAll();
//    }
}
