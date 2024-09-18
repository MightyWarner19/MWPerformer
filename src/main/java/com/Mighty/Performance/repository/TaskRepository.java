package com.Mighty.Performance.repository;

import com.Mighty.Performance.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task , String > {
}
