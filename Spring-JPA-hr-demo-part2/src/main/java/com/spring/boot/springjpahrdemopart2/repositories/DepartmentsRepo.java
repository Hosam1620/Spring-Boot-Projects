package com.spring.boot.springjpahrdemopart2.repositories;

import com.spring.boot.springjpahrdemopart2.entities.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepo extends JpaRepository<Departments,Long> {
}
