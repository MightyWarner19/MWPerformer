package com.Mighty.Performance.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee_info")
public class Employee {
    @Id
    private String empId;
    private String empName;
    private String empEmail;
    private String empPhone;
    private String empProfile;
    private String proId;
    private String teamId;

//    @OneToMany(mappedBy = "assignEmployee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Task> tasks;  // One-to-Many relationship with Task

    public Employee() {
        super();
    }

    public Employee(String empId, String empName, String empEmail, String empPhone, String empProfile, String proId, String teamId) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
        this.empProfile = empProfile;
        this.proId = proId;
        this.teamId = teamId;
    }

    // Getter and Setter for tasks
//
//    public List<Task> getTasks() {
//        return tasks;
//    }
//
//    public void setTasks(List<Task> tasks) {
//        this.tasks = tasks;
//    }

    // Other existing getters and setters...


    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpProfile() {
        return empProfile;
    }

    public void setEmpProfile(String empProfile) {
        this.empProfile = empProfile;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
