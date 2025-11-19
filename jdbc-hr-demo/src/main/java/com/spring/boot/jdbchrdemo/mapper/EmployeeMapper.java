package com.spring.boot.jdbchrdemo.mapper;

import com.spring.boot.jdbchrdemo.entity.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        // care about the column label that's name in a database not in your object .so you should remember that
        return new Employee(rs.getLong("Employee_id"), rs.getString("first_Name"), rs.getString("last_Name"), rs.getDouble("salary"));
    }
}
