package com.spring.boot.springjpahrdemopart2.controllers;

import com.spring.boot.springjpahrdemopart2.entities.Departments;
import com.spring.boot.springjpahrdemopart2.services.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentsController {
    public final DepartmentsService departmentsService;

    @Autowired
    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    //CRUD operations
    @GetMapping("/{id}")
    public Departments findDepartmentById(@PathVariable Long id) {
        return departmentsService.getDepartmentById(id);
    }

    //get all departments
    @GetMapping()
    public Iterable<Departments> FindAllDepartments() {
        return departmentsService.getAllDepartments();
    }

    //insert
    @PostMapping
    public Departments insertDepartment(@RequestBody Departments department) {
        return departmentsService.saveDepartment(department);
    }

    //update
    @PutMapping
    public Departments updateDepartment(@RequestBody Departments department) {
        return departmentsService.saveDepartment(department);
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentsService.deleteDepartment(id);
    }

}
