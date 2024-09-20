package com.Mighty.Performance.service;

import com.Mighty.Performance.dto.EmployeeDto;
import com.Mighty.Performance.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();
    Optional<EmployeeDto> getEmployeeById(String empId);
    void saveEmployee(EmployeeDto employeeDto);
    void updateEmployee(EmployeeDto employeeDto);
    void deleteEmployee(String empId);
//    public void deleteEmployeeById(String empId);


}
