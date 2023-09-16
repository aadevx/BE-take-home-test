package com.example.demo.repository;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductRepository {

    int save(Product product);

    int update(Product product);

    Product findById(Long id);

    int deleteById(Long id);

    List<Product> findAll();

    List<Product> search(String criteria, String value, String sort);

    List<Product> searchByRating(String sort);
}
