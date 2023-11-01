package com.example.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.crud.entities.Employee;
import com.example.crud.repositories.EmployeeRepository;
import com.example.crud.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository EmployeeRepository;

    @Override
    public Employee createEmployee(Employee Employee) {
        return EmployeeRepository.save(Employee);
    }

    @Override
    public Employee getEmployeeById(Long EmployeeId) {
        Optional<Employee> optionalEmployee = EmployeeRepository.findById(EmployeeId);
        return optionalEmployee.get();
    }

    @Override
    public List<Employee> getEmployeeByEmail(String email) {
        return EmployeeRepository.findByEmail(email);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return EmployeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee Employee) {
        Employee existingEmployee = EmployeeRepository.findById(Employee.getId()).get();
        existingEmployee.setFirstName(Employee.getFirstName());
        existingEmployee.setLastName(Employee.getLastName());
        existingEmployee.setEmail(Employee.getEmail());
        Employee updatedEmployee = EmployeeRepository.save(existingEmployee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(Long EmployeeId) {
        EmployeeRepository.deleteById(EmployeeId);
    }
}
