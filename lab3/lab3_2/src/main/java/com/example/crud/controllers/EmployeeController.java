package com.example.crud.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entities.Employee;
import com.example.crud.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService EmployeeService;

    // build create Employee REST API
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee Employee) {
        Employee savedEmployee = EmployeeService.createEmployee(Employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // build get Employee by id REST API
    // http://localhost:8080/api/Employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long EmployeeId) {
        Employee Employee = EmployeeService.getEmployeeById(EmployeeId);
        return new ResponseEntity<>(Employee, HttpStatus.OK);
    }

    // Build Get All Employees REST API
    // http://localhost:8080/api/Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(
            @RequestParam(name = "email", required = false) String email) {
        List<Employee> employees;
        if (email != null) {
            employees = EmployeeService.getEmployeeByEmail(email);
        } else {
            employees = EmployeeService.getAllEmployees();
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Build Update Employee REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/Employees/1
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long EmployeeId,
            @RequestBody Employee Employee) {
        Employee.setId(EmployeeId);
        Employee updatedEmployee = EmployeeService.updateEmployee(Employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long EmployeeId) {
        EmployeeService.deleteEmployee(EmployeeId);
        return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
    }
}
