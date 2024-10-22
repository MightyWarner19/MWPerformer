package com.Mighty.Performance.dto;

import java.time.LocalDate;

public class TaskDto {

    private Long taskId;
    private String taskName;
    private String proId;
    private String assignEmployee;  // The employee email instead of the entire Employee object
    private LocalDate taskStartDate;
    private LocalDate taskEndDate;
    private String taskDescription;
    private String taskStatus;  // New field to store task status

    // Constructors
    public TaskDto() {}

    public TaskDto(Long taskId, String taskName, String proId, String assignEmployee, LocalDate taskStartDate, LocalDate taskEndDate, String taskDescription, String taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.proId = proId;
        this.assignEmployee = assignEmployee;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
    }

    // Getters and Setters
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getAssignEmployee() {
        return assignEmployee;
    }

    public void setAssignEmployee(String assignEmployee) {
        this.assignEmployee = assignEmployee;
    }

    public LocalDate getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(LocalDate taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public LocalDate getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(LocalDate taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    // ToString method for debugging and logging purposes

}
