package com.Mighty.Performance.repository;

import com.Mighty.Performance.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, String>{
    Optional<Employee> findByEmpEmail(String empEmail);
}
