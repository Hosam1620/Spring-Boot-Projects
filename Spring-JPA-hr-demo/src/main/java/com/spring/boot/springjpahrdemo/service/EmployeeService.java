package com.spring.boot.springjpahrdemo.service;

import com.spring.boot.springjpahrdemo.entity.Employee;
import com.spring.boot.springjpahrdemo.repositroy.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow();
    }
    public Employee insertEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public Iterable<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }
    public List<Employee> findEmployeeByDepartmentId(Long departmentId){
        return employeeRepo.findByDepartmentIdId(departmentId);
    }

}
