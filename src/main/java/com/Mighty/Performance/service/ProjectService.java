package com.Mighty.Performance.service;

import com.Mighty.Performance.entity.Project;

import java.util.List;

public interface ProjectService {
    public String createProject(Project project);
    public String updateProject(Project project);
    public String deleteProject(Long id);
    public Project getProject(Long id);
    public List<Project> getAllProject();
}
