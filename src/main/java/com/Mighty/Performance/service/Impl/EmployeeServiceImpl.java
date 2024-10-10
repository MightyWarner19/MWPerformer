package com.Mighty.Performance.service.Impl;

import com.Mighty.Performance.dto.EmployeeDto;
import com.Mighty.Performance.entity.Employee;
import com.Mighty.Performance.entity.Team;
import com.Mighty.Performance.repository.EmployeeRepository;
import com.Mighty.Performance.repository.TeamRepository;
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

    @Autowired
    private TeamRepository teamRepository; // Inject TeamRepository

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

    // Convert Employee entity to EmployeeDto
    private EmployeeDto convertEntityToDto(Employee employee) {
        String teamId = (employee.getTeam() != null) ? employee.getTeam().getTeamId() : null; // Extract teamId from Team object
        return new EmployeeDto(
                employee.getEmpId(),
                employee.getEmpName(),
                employee.getEmpEmail(),
                employee.getEmpPhone(),
                employee.getEmpProfile(),
                employee.getProId(),
                teamId  // Set the teamId in the DTO
        );
    }

    // Convert EmployeeDto to Employee entity
    private Employee convertDtoToEntity(EmployeeDto employeeDto) {
        Team team = teamRepository.findByTeamId(employeeDto.getTeamId()).orElse(null); // Fetch Team object by teamId
        return new Employee(
                employeeDto.getEmpId(),
                employeeDto.getEmpName(),
                employeeDto.getEmpEmail(),
                employeeDto.getEmpPhone(),
                employeeDto.getEmpProfile(),
                employeeDto.getProId(),
                team  // Set the fetched Team object in the Employee entity
        );
    }

}
