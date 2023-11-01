package com.example.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmail(String email);
}
