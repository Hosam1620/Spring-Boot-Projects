package com.global.book.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.global.book.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "AUTHORS")
//to solve the loop problem we should use @JsonIdentityInfo annotation or @JsonIdentityReference annotation
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" )
//base Entity take type of id but auditing take type of column that we save created by or last modified by in it.
public class Author extends BaseEntity<Long> {
    @NotBlank//this check all the others
    //@NotNull
    //  @NotEmpty
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "NAME")
    private String name;
    @Pattern(regexp = "^([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})$")
    private String ipAddress;
    // private String statusCode;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }


    //public String getStatusCode() {
    //    return statusCode;
    //}

//    public void setStatusCode(String statusCode) {
//        this.statusCode = statusCode;
//    }

    //should say that to tell jpa don't create a new relation, this relation is found in the Book entity, and
    //you just mapped by it.
    @JsonManagedReference
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
