package com.global.book.testspecificationrepo.specification;

import com.global.book.testspecificationrepo.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

//we make specification to say that if we have optional or dynamic we should be using Criteria API
//to handle this thing.
public class ProductSpecification {
    public static Specification<Product> nameContains(String name) {
        return (root, query, cb) ->
                (name == null || name.isBlank()) ?
                        null :
                        cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Product> priceGte(BigDecimal minPrice) {
        return (root, query, cb) ->
                (minPrice == null)
                        ? null
                        : cb.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLte(BigDecimal maxPrice) {
        return (root, query, cb) ->
                (maxPrice == null)
                        ? null
                        : cb.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> isInStock(Boolean inStock) {
        return (root, query, cb) ->
                (inStock == null)
                        ? null
                        : cb.equal(root.get("inStock"), inStock);
    }


}
