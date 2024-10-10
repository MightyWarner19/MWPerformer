package com.Mighty.Performance.service;

import com.Mighty.Performance.dto.TeamDto;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    List<TeamDto> getAllTeams();
    Optional<TeamDto> getTeamById(String teamId);
    void saveTeam(TeamDto teamDto);
    void updateTeam(TeamDto teamDto);
    void deleteTeam(String teamId);
}