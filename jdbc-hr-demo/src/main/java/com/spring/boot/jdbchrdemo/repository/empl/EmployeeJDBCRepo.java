package com.spring.boot.jdbchrdemo.repository.empl;

import com.spring.boot.jdbchrdemo.entity.Employee;
import com.spring.boot.jdbchrdemo.mapper.EmployeeMapper;
import com.spring.boot.jdbchrdemo.repository.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@Qualifier("EmployeeJDBCRepo")
public class EmployeeJDBCRepo implements EmployeeRepos {


    private final JdbcTemplate jdbcTemplate;

    //more securely injects objects with constructor injections than using @Autowired on field direct .
    @Autowired
    public EmployeeJDBCRepo(JdbcTemplate jdbcTemplate, Employee employeeMapper) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer count() {
        // we are using Integer class instead of int as primitive because this method will return null if no data found.
        // if we use int as primitive, it will throw an exception if no data is found.
        // java returns types of date that you want to return, and you can use the wrapper classes.
        // the problem will appear here when java makes an unboxing operation on the return value of the method.
        // from Integer to int that gives us an exception because Integer is not a primitive type.
        String sql = "select count(*) from employees";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Employee findById(long id) {
        String sql = "SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,SALARY FROM EMPLOYEE WHERE EMPLOYEE_ID=?";
        // if we don't give this method, Row Mapper functional interface will give us an exception.
        // the new version of queryForObject method by using varargs instead of arrays like this.
        return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
        // Old version of queryForObject method
        // jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeMapper());
    }

    // this is one way by lambda //(rs, rowNum)->new Employee(rs.getLong("Employee_id"),rs.getString("first_Name"),rs.getDouble("salary")) );
    // here we just use lambda expression because this is a functional interface,
    // we can also make this definition external and call it here.
    @Override
    public List<Employee> findAll() {
        String sql = "SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,SALARY FROM EMPLOYEE";
        return jdbcTemplate.query(sql, new EmployeeMapper());
    }

    @Override
    public Integer insert(Employee employee) {
        String sql = "insert into employee(Employee_id,first_Name,last_Name,salary) values(?,?,?,?)";
        return jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getSalary());
    }

    @Override
    public Integer update(Employee employee) {
        String sql = "update employee set first_Name=?,last_Name=?,salary=? where Employee_id=?";
        return jdbcTemplate.update(sql,employee.getFirstName(),employee.getLastName(),employee.getSalary(),employee.getId());
    }

    @Override
    public Integer delete(long id) {
        String sql="delete from employee where Employee_id=?";
        return jdbcTemplate.update(sql,id);
    }

}
