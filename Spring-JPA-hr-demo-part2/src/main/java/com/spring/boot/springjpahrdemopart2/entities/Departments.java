package com.spring.boot.springjpahrdemopart2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DEPARTMENTS")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_NUM")
    private Long departmentNum;
    @Column(name = "NAME")
    private String name;

    public Departments() {
    }

    public Departments(Long id, String name) {
        this.departmentNum = id;
        this.name = name;
    }

    public Long getId() {
        return departmentNum;
    }

    public void setId(Long id) {
        this.departmentNum = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}