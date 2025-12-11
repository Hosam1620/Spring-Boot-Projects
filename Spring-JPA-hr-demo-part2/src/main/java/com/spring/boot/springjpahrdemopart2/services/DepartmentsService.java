package com.spring.boot.springjpahrdemopart2.services;

import com.spring.boot.springjpahrdemopart2.entities.Departments;
import com.spring.boot.springjpahrdemopart2.repositories.DepartmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentsService {
    private final DepartmentsRepo departmentsRepo;

    @Autowired
    public DepartmentsService(DepartmentsRepo departmentsRepo) {
        this.departmentsRepo = departmentsRepo;
    }
    // CRUD operations
    // get department by id
    public Departments getDepartmentById(Long id){
        return departmentsRepo.getById(id);
    }
    // update or insert departments
    public Departments saveDepartment(Departments department){
        return departmentsRepo.save(department);
    }
    // get all departments
    public Iterable<Departments> getAllDepartments(){
        return departmentsRepo.findAll();
    }
    // delete department
    public void deleteDepartment(Long id){
        departmentsRepo.deleteById(id);
    }
}
