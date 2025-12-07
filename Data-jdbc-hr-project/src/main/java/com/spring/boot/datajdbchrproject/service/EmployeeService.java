package com.spring.boot.datajdbchrproject.service;

import com.spring.boot.datajdbchrproject.entity.Employee;
import com.spring.boot.datajdbchrproject.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Iterable<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(long id) {
        return employeeRepo.findEmployeeById(id);
    }

    public Employee insertEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(long id) {
        employeeRepo.deleteById(id);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public long countEmployees() {
        return employeeRepo.count();
    }

    public int updateSalary(Long id, Double salary) {
        /*
         Employee employee = employeeRepo.findEmployeeById(id);
         employee.setSalary(salary);
        */
        return employeeRepo.updateSalary(id,salary);
    }
}
