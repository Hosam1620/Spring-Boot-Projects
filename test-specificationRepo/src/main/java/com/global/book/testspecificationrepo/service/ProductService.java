package com.global.book.testspecificationrepo.service;

import com.global.book.testspecificationrepo.entity.Product;
import com.global.book.testspecificationrepo.repo.ProductRepo;
import com.global.book.testspecificationrepo.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Page<Product> GetAllProducts(String name, BigDecimal minPrice, BigDecimal maxPrice, Boolean inStock,Integer pageNumber, Integer size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        Specification<Product> spec =
                Specification
                        .where(ProductSpecification.nameContains(name))
                        .and(ProductSpecification.isInStock(inStock))
                        .and(ProductSpecification.priceGte(minPrice))
                        .and(ProductSpecification.priceLte(maxPrice));
        return productRepo.findAll(spec, pageable);
    }
}
