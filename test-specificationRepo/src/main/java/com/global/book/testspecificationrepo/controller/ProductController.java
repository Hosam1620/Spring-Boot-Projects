package com.global.book.testspecificationrepo.controller;

import com.global.book.testspecificationrepo.entity.Product;
import com.global.book.testspecificationrepo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<Page<Product>> search(
            @RequestParam("name") String name,
            @RequestParam("minPrice") BigDecimal minPrice,
            @RequestParam("maxPrice") BigDecimal maxPrice,
            @RequestParam("inStock") Boolean inStock,
            @RequestParam("pageNumber") Integer pageNumber,
            @RequestParam("size") Integer size
    ) {
        return ResponseEntity.ok(productService.GetAllProducts(name, minPrice, maxPrice, inStock, pageNumber, size));
    }
}
