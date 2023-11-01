package com.example.crud.service;

import java.util.List;

import com.example.crud.entities.Employee;

public interface EmployeeService {
    Employee createEmployee(Employee Employee);

    Employee getEmployeeById(Long EmployeeId);

    List<Employee> getEmployeeByEmail(String email);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee Employee);

    void deleteEmployee(Long EmployeeId);
}
