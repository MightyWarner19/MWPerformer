package com.Mighty.Performance.service.Impl;

import com.Mighty.Performance.exception.EmployeeNotFoundException;
import com.Mighty.Performance.entity.Project;
import com.Mighty.Performance.repository.ProjectRepository;
import com.Mighty.Performance.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public String createProject(Project project) {
        projectRepository.save(project);
        return "Success";
    }

    @Override
    public String updateProject(Project project) {
        projectRepository.save(project);
        return "Success";
    }

    @Override
    public String deleteProject(Long id) {
        projectRepository.deleteById(id);
        return "Success";
    }

    @Override
    public Project getProject(Long id) {
        if (projectRepository.findById(id).isEmpty())
            throw new EmployeeNotFoundException("Requested Task does not exist");
        return projectRepository.findById(id).get();
    }

    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }
}