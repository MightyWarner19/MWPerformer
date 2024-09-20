package com.Mighty.Performance.service.Impl;

import com.Mighty.Performance.dto.EmployeeDto;
import com.Mighty.Performance.entity.Employee;
import com.Mighty.Performance.repository.EmployeeRepository;
import com.Mighty.Performance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeDto> getEmployeeById(String empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        return employee.map(this::convertEntityToDto);
    }

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee = convertDtoToEntity(employeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
        Employee employee = convertDtoToEntity(employeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String empId) {
        employeeRepository.deleteById(empId);
    }

    // Helper methods to convert between DTO and Entity
    private EmployeeDto convertEntityToDto(Employee employee) {
        return new EmployeeDto(
                employee.getEmpId(),
                employee.getEmpName(),
                employee.getEmpEmail(),
                employee.getEmpPhone(),
                employee.getEmpProfile(),
                employee.getProId(),
                employee.getTeamId()
        );
    }

    private Employee convertDtoToEntity(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getEmpId(),
                employeeDto.getEmpName(),
                employeeDto.getEmpEmail(),
                employeeDto.getEmpPhone(),
                employeeDto.getEmpProfile(),
                employeeDto.getProId(),
                employeeDto.getTeamId()
        );
    }
}
