package com.spring.boot.springjpahrdemopart2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SALARY")
    private Long salary;
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_NUM")
    private Departments department;

    public Employees() {
    }

    public Employees(Long id, String name, Long salary, Departments department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }
}
