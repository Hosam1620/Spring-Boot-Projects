package com.spring.boot.springjpahrdemo.repositroy;

import com.spring.boot.springjpahrdemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
