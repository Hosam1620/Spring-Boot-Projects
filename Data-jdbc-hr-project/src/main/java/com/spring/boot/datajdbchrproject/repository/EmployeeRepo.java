package com.spring.boot.datajdbchrproject.repository;

import com.spring.boot.datajdbchrproject.entity.Employee;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {

    List<Employee> findByFirstNameContaining(String firstName);

    // if we need to use custom queries, we can use @Query annotation.
    // the same thing if we used jdbcTemplate put this is easier than that.
    @Query(value = "SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,SALARY FROM EMPLOYEE WHERE EMPLOYEE_ID= :ID")
    Employee findEmployeeById(@Param("ID") long id);

    // if we want to update a column in a table, we can use @Modifying annotation.
    // to say to spring, this is a modification query.
    @Modifying
    @Query(value = "UPDATE EMPLOYEE SET SALARY = :SALARY WHERE EMPLOYEE_ID = :ID")
    Integer updateSalary(@Param("ID") Long id,@Param("SALARY") Double salary);
}
