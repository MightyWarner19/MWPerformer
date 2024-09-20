package com.Mighty.Performance.service.Impl;

import com.Mighty.Performance.dto.EmployeeDto;
import com.Mighty.Performance.dto.ProjectDto;
import com.Mighty.Performance.entity.Employee;
import com.Mighty.Performance.exception.EmployeeNotFoundException;
import com.Mighty.Performance.entity.Project;
import com.Mighty.Performance.repository.ProjectRepository;
import com.Mighty.Performance.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProjectDto> getProjectById(String proId) {
        Optional<Project> project = projectRepository.findById(proId);
        return project.map(this::convertEntityToDto);
    }

    @Override
    public void saveProject(ProjectDto projectDto) {
        Project project = convertDtoToEntity(projectDto);
        projectRepository.save(project);
    }

    @Override
    public void updateProject(ProjectDto projectDto) {
       Project project = convertDtoToEntity(projectDto);
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(String proId) {
        projectRepository.deleteById(proId);
    }

    // Helper methods to convert between DTO and Entity
    private ProjectDto convertEntityToDto(Project project) {
        return new ProjectDto(
                project.getProId(),
                project.getProName(),
                project.getProDescription(),
                project.getProStartDate(),
                project.getProEndDate(),
                project.getTeamId(),
                project.getProManager(),
                project.getStatus()
        );
    }

    private Project convertDtoToEntity(ProjectDto projectDto) {
        return new Project(
                projectDto.getProId(),
                projectDto.getProName(),
                projectDto.getProDescription(),
                projectDto.getProStartDate(),
                projectDto.getProEndDate(),
                projectDto.getTeamId(),
                projectDto.getProManager(),
                projectDto.getStatus()
        );
    }
}