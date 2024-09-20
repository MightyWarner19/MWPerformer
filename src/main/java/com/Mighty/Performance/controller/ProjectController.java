//package com.Mighty.Performance.controller;
//
//import com.Mighty.Performance.entity.Project;
//import com.Mighty.Performance.response.ResponseHandler;
//import com.Mighty.Performance.service.ProjectService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/projects")
//public class ProjectController {
//
//    ProjectService projectService;
//
//    public ProjectController(ProjectService projectService) {
//        this.projectService = projectService;
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getProjectDetails(@PathVariable("id") Long id) {
//
//        return ResponseHandler.responseBuilder("Here is the all details", HttpStatus.OK,projectService.getProject(id));
//    }
//
//    @GetMapping()
//    public List<Project> getAllProjectDetails() {
//        return projectService.getAllProject();
//    }
//
//    @PostMapping
//    public String createProjectDetails(@RequestBody Project project){
//        projectService.createProject(project);
//        return "Project details added successfully";
//    }
//
//    @PutMapping
//    public String updateProjectDetails(@RequestBody Project project){
//        projectService.updateProject(project);
//        return "project details updated successfully";
//    }
//
//    @DeleteMapping("{id}")
//    public String deleteProjectDetails(@PathVariable("id") Long id) {
//        projectService.deleteProject(id);
//        return "Project details deleted successfully";
//    }
//}
//
