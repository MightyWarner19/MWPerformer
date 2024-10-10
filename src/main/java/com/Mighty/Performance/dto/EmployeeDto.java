package com.Mighty.Performance.dto;

public class EmployeeDto {
    private String empId;
    private String empName;
    private String empEmail;
    private String empPhone;
    private String empProfile;
    private String proId;
    private String teamId;  // To store the team ID or any relevant team info

    public EmployeeDto() {
        super();
    }

    public EmployeeDto(String empId, String empName, String empEmail, String empPhone, String empProfile, String proId, String teamId) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
        this.empProfile = empProfile;
        this.proId = proId;
        this.teamId = teamId;
    }

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
