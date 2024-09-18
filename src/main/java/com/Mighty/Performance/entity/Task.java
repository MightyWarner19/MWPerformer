package com.Mighty.Performance.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    private String taskTittle;
    private String taskDescription;
    private String assignEmployee;
    private String projectName;
    private String taskPriority;
    private String taskStartDate;
    private String taskDeadline;
    private String taskDependencies;
    private String taskAttachment;
    private String taskType;
    private String taskTag;

    public Task() {
    }

    public Task(String taskTittle, String taskDescription, String assignEmployee, String projectName, String taskPriority, String taskStartDate, String taskDeadline, String taskDependencies, String taskAttachment, String taskType, String taskTag) {
        this.taskTittle = taskTittle;
        this.taskDescription = taskDescription;
        this.assignEmployee = assignEmployee;
        this.projectName = projectName;
        this.taskPriority = taskPriority;
        this.taskStartDate = taskStartDate;
        this.taskDeadline = taskDeadline;
        this.taskDependencies = taskDependencies;
        this.taskAttachment = taskAttachment;
        this.taskType = taskType;
        this.taskTag = taskTag;
    }

    public String getTaskTittle() {
        return taskTittle;
    }

    public void setTaskTittle(String taskTittle) {
        this.taskTittle = taskTittle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getAssignEmployee() {
        return assignEmployee;
    }

    public void setAssignEmployee(String assignEmployee) {
        this.assignEmployee = assignEmployee;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(String taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public String getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(String taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    public String getTaskDependencies() {
        return taskDependencies;
    }

    public void setTaskDependencies(String taskDependencies) {
        this.taskDependencies = taskDependencies;
    }

    public String getTaskAttachment() {
        return taskAttachment;
    }

    public void setTaskAttachment(String taskAttachment) {
        this.taskAttachment = taskAttachment;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskTag() {
        return taskTag;
    }

    public void setTaskTag(String taskTag) {
        this.taskTag = taskTag;
    }
}
