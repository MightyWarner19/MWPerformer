package com.Mighty.Performance.service.Impl;

import com.Mighty.Performance.dto.TeamDto;
import com.Mighty.Performance.entity.Team;
import com.Mighty.Performance.entity.Employee;
import com.Mighty.Performance.repository.TeamRepository;
import com.Mighty.Performance.repository.EmployeeRepository;
import com.Mighty.Performance.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Convert Team entity to TeamDto
    private TeamDto convertEntityToDto(Team team) {
        List<String> employeeEmails = team.getEmployees()
                .stream()
                .map(Employee::getEmpEmail)  // Get employee email from Employee entity
                .collect(Collectors.toList());

        return new TeamDto(team.getTeamId(), employeeEmails);
    }

    // Convert TeamDto to Team entity
    private Team convertDtoToEntity(TeamDto teamDto) {
        List<Employee> employees = teamDto.getEmployeeEmails().stream()
                .map(email -> employeeRepository.findByEmpEmail(email)
                        .orElse(null))  // Find employees by their email
                .filter(Objects::nonNull)  // Filter out nulls in case no match found
                .collect(Collectors.toList());

        Team team = new Team();
        team.setTeamId(teamDto.getTeamId());
        team.setEmployees(employees);

        return team;
    }



    // Get all teams
    @Override
    public List<TeamDto> getAllTeams() {
        List<Team> teams = teamRepository.findAll();  // Retrieve all teams from the database
        return teams.stream()
                .map(this::convertEntityToDto)  // Convert each Team entity to TeamDto
                .collect(Collectors.toList());
    }

    // Get a team by ID
    @Override
    public Optional<TeamDto> getTeamById(String teamId) {
        Optional<Team> team = teamRepository.findById(teamId);  // Retrieve the team by teamId
        return team.map(this::convertEntityToDto);  // Convert to TeamDto if team exists
    }

    // Save a new team
    @Override
    public void saveTeam(TeamDto teamDto) {
        // Convert the DTO to the Team entity
        Team team = convertDtoToEntity(teamDto);

        // Loop through employee emails and set the team for each employee
        List<Employee> employees = team.getEmployees();
        if (employees != null) {
            for (Employee employee : employees) {
                employee.setTeam(team); // Set the team for each employee
            }
        }

        // Save the team and associated employees
        teamRepository.save(team);
    }


    // Update an existing team
    @Override
    public void updateTeam(TeamDto teamDto) {
        Optional<Team> existingTeam = teamRepository.findById(teamDto.getTeamId());  // Check if the team exists
        if (existingTeam.isPresent()) {
            Team team = convertDtoToEntity(teamDto);  // Convert TeamDto to Team entity
            teamRepository.save(team);  // Update the team in the database
        }
    }

    // Delete a team by ID
    @Override
    public void deleteTeam(String teamId) {
        teamRepository.deleteById(teamId);  // Delete the team by teamId
    }
}
