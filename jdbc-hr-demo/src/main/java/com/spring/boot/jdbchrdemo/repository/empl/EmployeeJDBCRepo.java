package com.spring.boot.jdbchrdemo.repository.empl;

import com.spring.boot.jdbchrdemo.entity.Employee;
import com.spring.boot.jdbchrdemo.mapper.EmployeeMapper;
import com.spring.boot.jdbchrdemo.repository.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class EmployeeJDBCRepo implements EmployeeRepos {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private Employee employeeMapper ;
    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from employees", Integer.class);
    }

    @Override
    public Employee findById(long id) {
        String sql = "select Employee_id,Concat(first_Name,last_name) as fullname,salary from employees where Employee_id=?";
        //if we don't give this method Row Mapper functional interface will give us exception
        return jdbcTemplate.queryForObject(sql,new Object[] {id},new EmployeeMapper());
    }
        // this is one way by lambda        //(rs, rowNum)->new Employee(rs.getLong("Employee_id"),rs.getString("first_Name"),rs.getDouble("salary")) );
     // here we just use lambda expression because this is a functional interface,
        // we can also make this definition external and call it here .
    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public int insert(Employee employee) {
        return 0;
    }

    @Override
    public int update(Employee employee) {
        return 0;
    }

    @Override
    public int delete(long id) {
        return 0;
    }
}
