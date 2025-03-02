package com.employee.demo.Controller;

import org.springframework.web.bind.annotation.*;

import com.employee.demo.entity.Employee;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")  // Base path for all routes
public class EmployeeController {
    
    private Map<Long, Employee> employeeMap = new HashMap<>();

    // Get all employees
    @GetMapping("/getall")
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    // Register a new employee
    @PostMapping("/register")
    public boolean createEmployee(@RequestBody Employee employee) {
        employeeMap.put(employee.getId(), employee);
        return true;
    }

    // Get employee by ID
    @GetMapping("/id/{empId}")
    public Employee getEmployeeById(@PathVariable Long empId) {
        return employeeMap.get(empId);
    }

    // Delete employee by ID
    @DeleteMapping("/id/{empId}")
    public Employee deleteEmployeeById(@PathVariable Long empId) {
        return employeeMap.remove(empId);
    }

    // Update employee by ID
    @PutMapping("/update/{empId}")
    public Employee updateEmployeeById(@PathVariable Long empId, @RequestBody Employee employee) {
        return employeeMap.put(empId, employee);
    }

    // Health Check API
    @GetMapping("/health")
    public String healthCheck() {
        return "Employee Service is Running";
    }
}
