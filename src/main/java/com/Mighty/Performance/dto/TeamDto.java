package com.Mighty.Performance.dto;

import java.util.ArrayList;
import java.util.List;

public class TeamDto {
    private String teamId;
    private List<String> employeeEmails = new ArrayList<>();  // A list of employee emails

    public TeamDto() {
        super();
    }

    public TeamDto(String teamId, List<String> employeeEmails) {
        this.teamId = teamId;
        this.employeeEmails = employeeEmails;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public List<String> getEmployeeEmails() {
        return employeeEmails;
    }

    public void setEmployeeEmails(List<String> employeeEmails) {
        this.employeeEmails = employeeEmails;
    }
}
