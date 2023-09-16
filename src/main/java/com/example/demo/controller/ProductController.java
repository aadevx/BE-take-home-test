package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Operation(summary = "Get list product", description = "Returns list product")
    @GetMapping()
    public List<Product> index() {
        return productRepository.findAll();
    }

    @Operation(summary = "Get a product by id", description = "Returns a product as per the id")
    @GetMapping("/{id}")
    public Product findById(@PathVariable(value = "id") Long id) {
        return productRepository.findById(id);
    }

    @Operation(summary = "add product", description = "add product")
    @PostMapping("/add")
    public String add(@RequestBody Product product) {
        productRepository.save(product);
        return "success add product";
    }

    @Operation(summary = "save product by id", description = "save product as per the id")
    @PostMapping("/save/{id}")
    public String save(@PathVariable(value = "id") Long id, @RequestBody Product product) {
        product.setId(id);
        productRepository.update(product);
        return "sucees update product";
    }

    @Operation(summary = "search product by criteria", description = "Returns list product as per criteria")
    @GetMapping("/search/{criteria}")
    public List<Product> searchCriteria(@PathVariable(value = "criteria") String criteria, @RequestParam String value, @RequestParam(defaultValue = "newest") String sort) {
        if(sort.equalsIgnoreCase("oldest"))
            sort = "create_date ASC";
        else
            sort = "create_date DESC";
        return productRepository.search(criteria.toLowerCase(), value, sort);
    }

    @Operation(summary = "Get a product by rating", description = "Returns a product as per rating")
    @GetMapping("/rating/{sort}")
    public List<Product> searchCriteria(@PathVariable(value = "sort") String sort) {
        if(sort.equalsIgnoreCase("high"))
            sort = "rating DESC";
        else if(sort.equalsIgnoreCase("lowest"))
            sort = "rating ASC";
        return productRepository.searchByRating(sort);
    }
}
