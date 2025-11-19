package com.spring.boot.jdbchrdemo.repository;

import com.spring.boot.jdbchrdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepos {

    Integer count();
    Employee findById(long id);
    List<Employee> findAll();
    Integer insert(Employee employee);
    Integer update(Employee employee);
    Integer delete(long id);
}
