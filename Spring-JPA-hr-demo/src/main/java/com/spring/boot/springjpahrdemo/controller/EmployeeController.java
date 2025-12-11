package com.spring.boot.springjpahrdemo.controller;

import com.spring.boot.springjpahrdemo.entity.Employee;
import com.spring.boot.springjpahrdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/id")
    public Employee findById(@RequestParam("id") Long id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping()
    public Employee insertEmployee(@RequestBody Employee employee) {
        return employeeService.insertEmployee(employee);
    }

    @DeleteMapping()
    public void deleteEmployee(@RequestParam("id") Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping()
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping()
    public Iterable<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }
    @GetMapping("/department")
    public List<Employee> findEmployeeByDepartmentId(@RequestParam("departmentId") Long departmentId) {
        return employeeService.findEmployeeByDepartmentId(departmentId);
    }
}
