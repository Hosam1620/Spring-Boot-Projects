package com.spring.boot.springjpahrdemo.repositroy;

import com.spring.boot.springjpahrdemo.entity.Department;
import com.spring.boot.springjpahrdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//types of repository interfaces
//CrudRepository<,>
//sortingAndPagingRepository
//jpaRepository
//every repo from down to up is extended from the previous
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentIdId(Long departmentId);
}
