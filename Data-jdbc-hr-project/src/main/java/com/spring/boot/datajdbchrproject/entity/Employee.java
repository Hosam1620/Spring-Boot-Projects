package com.spring.boot.datajdbchrproject.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("EMPLOYEE")
public class Employee {
    //the name of this column in a database is Employee_ID, so we need to use @column annotation to specify it.
    @Id
    @Column("EMPLOYEE_ID")
    private long id;
    // we don't need to specify columns' name because it is the same as the property name.
    @Column("FIRST_NAME")
    private String firstName;
    @Column("LAST_NAME")
    private String lastName;
    @Column("SALARY")
    private double salary;
    // but if we give the name,it's not a problem.
    //    @Transient
    //    private final String companyName = "HaSSoma Tech";
    // @Transient just doesn't modify this column in a database, but it's not forbidding it to mapping to JSON file.

    //    public String getCompanyName() {
    //
    //        return companyName;
    //    }

    public Employee() {
    }

    public Employee(long id, String firstName, String lastName, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
