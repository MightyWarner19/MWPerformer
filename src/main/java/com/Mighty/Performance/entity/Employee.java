package com.Mighty.Performance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_info")
public class Employee {

    @Id
    private String empId;
    private String empName;

    @Column(unique = true, nullable = false)
    private String empEmail;

    private String empPhone;
    private String empProfile;
    private String proId;  // Represents the project this employee is working on

    // Linking the Employee to the Team using @ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)  // Fetch lazily to avoid unnecessary data loading
    @JoinColumn(name = "teamId")
    private Team team;

    public Employee() {
        super();
    }

    public Employee(String empId, String empName, String empEmail, String empPhone, String empProfile, String proId, Team team) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
        this.empProfile = empProfile;
        this.proId = proId;
        this.team = team;
    }

    // Getters and Setters
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
