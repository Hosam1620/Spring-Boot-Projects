package com.spring.boot.springjpahrdemopart2.repositories;

import com.spring.boot.springjpahrdemopart2.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepo extends JpaRepository<Employees,Long> {
}
