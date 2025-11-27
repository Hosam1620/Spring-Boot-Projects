package com.spring.boot.jdbchrdemo.controller;

import com.spring.boot.jdbchrdemo.entity.Employee;
import com.spring.boot.jdbchrdemo.repository.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepos employeeRepos;

    private final EmployeeRepos employeeRepo;
    @Autowired
    public EmployeeController(@Qualifier("EmployeeJDBCRepo")EmployeeRepos employeeRepos,@Qualifier("EmployeeNamedParameterJDBCRepo") EmployeeRepos employeeRepo) {
        this.employeeRepos = employeeRepos;
        this.employeeRepo = employeeRepo;
    }


    @GetMapping("/count")
    public int CountEmployee() {
        return employeeRepos.count();
    }

    @GetMapping("/employeebyid")
    public Employee findByID(@RequestParam long id) {
        return employeeRepos.findById(id);
    }

    @GetMapping("")
    public List<Employee> findAll() {
        return employeeRepos.findAll();
    }

    // we should use Post Mapping if we want to insert data or update data.
    @GetMapping("/insert")
    public int insert(@RequestParam long id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam double salary) {
        return employeeRepos.insert(new Employee(id, firstname, lastname, salary));
    }

    @GetMapping("/update")
    public int update(@RequestParam long id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam double salary) {
        return employeeRepos.update(new Employee(id, firstname, lastname, salary));
    }

    @GetMapping("/delete")
    public int delete(@RequestParam long id) {
        return employeeRepos.delete(id);
    }

    @GetMapping("/insertwithnamedparameter")
    public int insertbyname(@RequestParam long id,@RequestParam String firstname, @RequestParam String lastname, @RequestParam double salary) {
        return employeeRepo.insert(new Employee(id, firstname, lastname, salary));
    }
}
