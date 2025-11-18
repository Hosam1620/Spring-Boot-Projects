package com.spring.boot.jdbchrdemo.repository;

import com.spring.boot.jdbchrdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepos {

    int count();
    Employee findById(long id);
    List<Employee> findAll();
    int insert(Employee employee);
    int update(Employee employee);
    int delete(long id);
}
