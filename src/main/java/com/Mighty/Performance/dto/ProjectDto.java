package com.Mighty.Performance.dto;

import java.time.LocalDate;

public class ProjectDto {

    private String proId;

    //    @Column(nullable = false, length = 100)
    private String proName;

    //    @Column(length = 500)
    private String proDescription;

    //    @Column(nullable = false)
    private LocalDate proStartDate;

    //    @Column(nullable = false)
    private LocalDate proEndDate;

    //    @Column(nullable = false)
    private  String teamId;

    private String proManager;

    private String status;

    public ProjectDto() {
        super();
    }


    public ProjectDto(String proId, String proName, String proDescription, LocalDate proStartDate, LocalDate proEndDate, String teamId, String proManager, String status) {
        this.proId = proId;
        this.proName = proName;
        this.proDescription = proDescription;
        this.proStartDate = proStartDate;
        this.proEndDate = proEndDate;
        this.teamId = teamId;
        this.proManager = proManager;
        this.status = status;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public LocalDate getProStartDate() {
        return proStartDate;
    }

    public void setProStartDate(LocalDate proStartDate) {
        this.proStartDate = proStartDate;
    }

    public LocalDate getProEndDate() {
        return proEndDate;
    }

    public void setProEndDate(LocalDate proEndDate) {
        this.proEndDate = proEndDate;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getProManager() {
        return proManager;
    }

    public void setProManager(String proManager) {
        this.proManager = proManager;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
