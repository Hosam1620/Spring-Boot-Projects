package com.spring.boot.jdbchrdemo.controller;

import com.spring.boot.jdbchrdemo.entity.Employee;
import com.spring.boot.jdbchrdemo.repository.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepos employeeRepos;
    @GetMapping("/count")
    public int CountEmployee()
    {
        return employeeRepos.count();
    }
    @GetMapping("/{id}")
    public Employee findByID(@PathVariable long id)
    {
        return employeeRepos.findById(id);
    }
}
