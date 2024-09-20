package com.Mighty.Performance.service;

import com.Mighty.Performance.dto.EmployeeDto;
import com.Mighty.Performance.dto.ProjectDto;
import com.Mighty.Performance.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<ProjectDto> getAllProjects();
    Optional<ProjectDto> getProjectById(String proId);
    void saveProject(ProjectDto projectDto);
    void updateProject(ProjectDto projectDto);
    void deleteProject(String proId);
}
