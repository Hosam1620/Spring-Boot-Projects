package com.spring.boot.springjpahrdemo.controller;

import com.spring.boot.springjpahrdemo.entity.Department;
import com.spring.boot.springjpahrdemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public List<Department> findAllDepartments() {
        return departmentService.findAllDepartments();
    }

    @GetMapping("/id")
    public Department findDepartmentById(@RequestParam("id") Long id) {
        return departmentService.findDepartmentById(id);
    }

    @PostMapping()
    public Department insertDepartment(@RequestBody Department department) {
        return departmentService.insertDepartment(department);
    }

    @PutMapping()
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping()
    public void deleteDepartment(@RequestParam("id") Long id) {
        departmentService.deleteDepartment(id);
    }


}
