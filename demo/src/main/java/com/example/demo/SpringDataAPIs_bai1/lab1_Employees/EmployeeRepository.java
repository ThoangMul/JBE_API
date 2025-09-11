package com.example.demo.SpringDataAPIs_bai1.lab1_Employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // find employee with supervisor id
    List<Employee> findBySupervisorId (Integer supervisorId);
}
