package com.Mighty.Performance.repository;

import com.Mighty.Performance.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task , Long> {

    List<Task> findByAssignEmployeeEmpEmail(String empEmail);
}
