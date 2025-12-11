package com.spring.boot.springjpahrdemopart2.services;

import com.spring.boot.springjpahrdemopart2.entities.Employees;
import com.spring.boot.springjpahrdemopart2.repositories.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeesService {
    private final EmployeesRepo employeesRepo;

    @Autowired
    public EmployeesService(EmployeesRepo employeesRepo) {
        this.employeesRepo = employeesRepo;
    }

    // find by id
    public Employees getEmployeeById(Long id) {
        return employeesRepo.getById(id);
    }

    // find all
    public Iterable<Employees> getAllEmployees() {
        return employeesRepo.findAll();
    }

    // insert or update
    public Employees saveEmployee(Employees employees) {
        return employeesRepo.save(employees);
    }

    // delete
    public void deleteEmployee(Long id) {
        employeesRepo.deleteById(id);
    }

}
