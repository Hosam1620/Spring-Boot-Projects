package com.global.book.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.global.book.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "BOOKS")
//also to solve the loop problem
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Book extends BaseEntity<Long> {
    @NotEmpty
    @NotNull
    @NotBlank
    private String name;
    @Min(value = 5)
    @Max(value = 50000)
    private double price;

    private String statusCode;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    //relation between Author and his book.

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;
    //third solution, but use it carefully
    @Formula("price*.25")
    private double discount;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Transient
    private double totalPrice;

    @PostLoad
    public void postLoad() {
        totalPrice = price + discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
//    @Transient
//    private double discount;
//
//    @PostLoad
//    public void postLoad() {
//        setDiscount();
//    }
//    public double getDiscount() {
//        return discount;
//    }
//
//    public void setDiscount() {
//        this.discount = price*.25;
//    }

    public Book() {
    }

    public Book(String name, double price, Author author) {

        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
