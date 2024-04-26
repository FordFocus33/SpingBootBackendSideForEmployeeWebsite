package com.monster.baster.club.spingbootbackendsideforemployeewebsite.service;

import com.monster.baster.club.spingbootbackendsideforemployeewebsite.entity.Employee;
import com.monster.baster.club.spingbootbackendsideforemployeewebsite.exceptions.UserNotFoundException;
import com.monster.baster.club.spingbootbackendsideforemployeewebsite.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());

        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        Employee updatedEmployee = employeeRepository.findById(employee.getId()).orElseThrow(() -> new UserNotFoundException("There is no user with id " + employee.getId()));

        updatedEmployee.setName(employee.getName());
        updatedEmployee.setEmail(employee.getEmail());
        updatedEmployee.setEmployeeCode(employee.getEmployeeCode());
        updatedEmployee.setImgUrl(employee.getImgUrl());
        updatedEmployee.setJobTitle(employee.getJobTitle());
        updatedEmployee.setPhoneNumber(employee.getPhoneNumber());

        return employeeRepository.save(updatedEmployee);
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("There is no user with ID like this " + id));
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
