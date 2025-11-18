package com.spring.boot.jdbchrdemo.mapper;

import com.spring.boot.jdbchrdemo.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        // care about column label that's name in database not in your object .so you should remember that
        return new Employee(rs.getLong("Employee_id"),rs.getString("fullName"),rs.getDouble("salary"));
    }
}
