package com.spring.boot.jdbchrdemo.repository.empl;

import com.spring.boot.jdbchrdemo.entity.Employee;
import com.spring.boot.jdbchrdemo.mapper.EmployeeMapper;
import com.spring.boot.jdbchrdemo.repository.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("EmployeeNamedParameterJDBCRepo")
public class EmployeeNamedParameterJDBCRepo implements EmployeeRepos {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //more securely injects objects with constructor injections than using @Autowired on field direct .
    @Autowired
    public EmployeeNamedParameterJDBCRepo(JdbcTemplate jdbcTemplate,NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer count() {
        String sql = "select count(*) from employees";
        return 0;//jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Employee findById(long id) {
        String sql = "SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,SALARY FROM EMPLOYEE WHERE EMPLOYEE_ID= :id";
        return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource("id",id), new EmployeeMapper());
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,SALARY FROM EMPLOYEE";
        return jdbcTemplate.query(sql, new EmployeeMapper());
    }

    @Override
    public Integer insert(Employee employee) {
        String sql = "insert into employee(Employee_id,first_Name,last_Name,salary) values(:id,:firstName,:lastName,:salary)";
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public Integer update(Employee employee) {
        String sql = "update employee set first_Name=:firstName,last_Name=:lastName,salary=:salary where Employee_id=:id";
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee));

        //jdbcTemplate.update(sql,employee.getFirstName(),employee.getLastName(),employee.getSalary(),employee.getId());
    }

    @Override
    public Integer delete(long id) {
        String sql="delete from employee where Employee_id=?";
        return jdbcTemplate.update(sql,id);
    }
}
