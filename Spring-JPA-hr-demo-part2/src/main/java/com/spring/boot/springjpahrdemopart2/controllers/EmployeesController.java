package com.spring.boot.springjpahrdemopart2.controllers;

import com.spring.boot.springjpahrdemopart2.entities.Employees;
import com.spring.boot.springjpahrdemopart2.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeesController {
    private final EmployeesService departmentService;

    @Autowired
    public EmployeesController(EmployeesService departmentService) {
        this.departmentService = departmentService;
    }

    //CRUD operations
    //find by id
    @RequestMapping("/{id}")
    public Employees findEmployeeById(@PathVariable Long id) {
        return departmentService.getEmployeeById(id);
    }

    //find all
    @RequestMapping()
    public Iterable<Employees> findAllEmployees() {
        return departmentService.getAllEmployees();
    }

    //insert
    @PostMapping()
    public Employees insertEmployee(@RequestBody Employees employees) {
        return departmentService.saveEmployee(employees);
    }

    //update
    @PutMapping
    public Employees updateEmployee(@RequestBody Employees employees) {
        return departmentService.saveEmployee(employees);
    }
    //delete
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        departmentService.deleteEmployee(id);
    }

}
