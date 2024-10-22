package com.Mighty.Performance.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;  // Use Long for generated IDs

    private String taskName;
    private String proId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empId", nullable = false) // Reference employee_id from Employee entity
    private Employee assignEmployee;  // Store Employee object instead of just email

    private LocalDate taskStartDate;

    private LocalDate taskEndDate;

    private String taskDescription;

    private String taskStatus;  // New field to store task status set by employee

    // Constructors, getters, setters

    public Task() {
        super();
    }

    public Task(Long taskId, String taskName, String proId, Employee assignEmployee, LocalDate taskStartDate, LocalDate taskEndDate, String taskDescription, String taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.proId = proId;
        this.assignEmployee = assignEmployee;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
    }

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

    public Employee getAssignEmployee() {
        return assignEmployee;
    }

    public void setAssignEmployee(Employee assignEmployee) {
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
}
