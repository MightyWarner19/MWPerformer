package com.Mighty.Performance.repository;

import com.Mighty.Performance.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, String> {

}
