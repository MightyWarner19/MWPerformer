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

//    @ManyToOne(fetch = FetchType.LAZY)  // Specify relationship
//    @JoinColumn(name = "empId", nullable = false) // Reference employee_id from Employee entity
    private String assignEmployee;  // Store Employee object instead of just the email

    private LocalDate taskStartDate;

    //    @Column(nullable = false)
    private LocalDate taskEndDate;
    private String taskDescription;
    // Constructors, getters, setters


    public Task() {
        super();
    }

    public Task(Long taskId, String taskName, String proId, String assignEmployee, LocalDate taskStartDate, LocalDate taskEndDate, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.proId = proId;
        this.assignEmployee = assignEmployee;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
        this.taskDescription = taskDescription;
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
}
