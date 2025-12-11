package com.spring.boot.springjpahrdemo.service;

import com.spring.boot.springjpahrdemo.entity.Department;
import com.spring.boot.springjpahrdemo.repositroy.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department findDepartmentById(Long id){
        return departmentRepo.findById(id).orElseThrow();
        //there are some methods to handle null values like get() or orElseThrow() or elseGet()
        // orElseGet(()->new Department()) all these methods are used to handle null values
    }

    public Department insertDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public Department updateDepartment(Department department){
        return departmentRepo.save(department);
    }

    public void deleteDepartment(Long id){
        departmentRepo.deleteById(id);
    }
    public List<Department> findAllDepartments(){
        return departmentRepo.findAll();
    }
}
