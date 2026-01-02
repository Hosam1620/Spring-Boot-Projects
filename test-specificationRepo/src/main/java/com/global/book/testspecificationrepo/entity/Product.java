package com.global.book.testspecificationrepo.entity;

import com.global.book.testspecificationrepo.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseEntity<Long> {
    @NotBlank
    private String name;

    private BigDecimal price;

    private Boolean inStock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }
//    @ManyToOne
//    private Category category;
}
