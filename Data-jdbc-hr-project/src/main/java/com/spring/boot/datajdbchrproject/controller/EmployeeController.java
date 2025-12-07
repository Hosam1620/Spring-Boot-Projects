package com.spring.boot.datajdbchrproject.controller;

import com.spring.boot.datajdbchrproject.entity.Employee;
import com.spring.boot.datajdbchrproject.repository.EmployeeRepo;
import com.spring.boot.datajdbchrproject.service.EmployeeService;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Employees")
public class EmployeeController {
//    private final EmployeeRepo employeeRepo;
//
//    @Autowired
//    public EmployeeController(EmployeeRepo employeeRepo) {
//        this.employeeRepo = employeeRepo;
//    }
    private final EmployeeService employeeservice;
    @Autowired
    public EmployeeController(EmployeeService employeeservice) {
        this.employeeservice = employeeservice;
    }
    @GetMapping("/NumberOfEmployee")
    public long employeeCount() {
        return employeeservice.countEmployees();//employeeRepo.count();
    }
    @GetMapping
    public Iterable<Employee> findAllEmployees() {
        return employeeservice.findAllEmployees();//employeeRepo.findAll();
    }
    @GetMapping("/FindBySubString")
    public List<Employee> findBySubstring(@RequestParam String firstname) {
        return null;//employeeRepo.findByFirstNameContaining(firstname);
    }

    @GetMapping("/FindEmployeeById")
    public Employee findEmployeeById(@RequestParam long id) {
        return employeeservice.findEmployeeById(id);//employeeRepo.findEmployeeById(id);
    }
    //@PostMapping()
    @RequestMapping(method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeservice.insertEmployee(employee);//employeeRepo.save(employee);
    }
    @PutMapping()
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeservice.updateEmployee(employee);//employeeRepo.save(employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeservice.deleteEmployee(id);//employeeRepo.deleteById(id);
    }
//    @PatchMapping()
//    public Employee patchEmployee(@RequestBody Employee employee) {
//        return employeeservice.;//employeeRepo.save(employee);
//    }
    @PutMapping("/Salary")
    public int updateSalary(@RequestParam long id,@RequestParam double salary) {
        return employeeservice.updateSalary(id,salary);//employeeRepo.updateSalary(id,salary);
    }
}
