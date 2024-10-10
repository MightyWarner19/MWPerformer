package com.Mighty.Performance.repository;

import com.Mighty.Performance.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TeamRepository extends JpaRepository<Team , String> {
    Optional<Team> findByTeamId(String teamId);
    // Custom method to find by teamId
}
