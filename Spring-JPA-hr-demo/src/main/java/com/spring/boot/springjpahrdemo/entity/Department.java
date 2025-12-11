package com.spring.boot.springjpahrdemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {
    @Id
    @Column(name = "DEPARTMENT_ID")
    private Long id;
    @Column(name = "DEPARTMENT_NAME")
    private String name;
    @Column(name = "MANAGER_ID")
    private Long managerId;
    @Column(name = "LOCATION_ID")
    private Long locationId;
    // to say that this is bidirectional relationship here and in employee also
    // , but we should say that mappedBy= name of the column in other object

    @OneToMany(mappedBy = "departmentId")
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    //we can make a bidirectional relationship but be careful because it will give you a
    //infinite loop if you let it convert from both side in two object
    //you should make one of them @JsonIgnore


    public Department(Long id, String name, Long managerId, Long locationId, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.locationId = locationId;
        this.employees = employees;
    }

    public Department() {
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

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
