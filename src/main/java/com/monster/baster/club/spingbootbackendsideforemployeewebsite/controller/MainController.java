package com.monster.baster.club.spingbootbackendsideforemployeewebsite.controller;

import com.monster.baster.club.spingbootbackendsideforemployeewebsite.entity.Employee;
import com.monster.baster.club.spingbootbackendsideforemployeewebsite.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class MainController {

    private EmployeeService employeeService;

    @Autowired
    public MainController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    private ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmpl = employeeService.addEmployee(employee);

        return new ResponseEntity<>(newEmpl, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    private ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updatedEmpl = employeeService.updateEmployee(employee);

        return new ResponseEntity<>(updatedEmpl, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
