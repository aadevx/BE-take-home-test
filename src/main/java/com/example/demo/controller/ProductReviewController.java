package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.ProductReviews;
import com.example.demo.repository.ProductReviewRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ProductReviewController {

    @Autowired
    private ProductReviewRepository productReviewRepository;

    @Operation(summary = "list review", description = "list review")
    @GetMapping()
    public List<ProductReviews> index() {
        return productReviewRepository.findAll();
    }

    @Operation(summary = "Get a review by id", description = "Returns a review as per the id")
    @GetMapping("/{id}")
    public ProductReviews findById(@PathVariable(value = "id") Long id) {
        return productReviewRepository.findById(id);
    }

    @Operation(summary = "add review ", description = "add review")
    @PostMapping("/add")
    public String add(@RequestBody ProductReviews product) {
        productReviewRepository.save(product);
        return "success add product";
    }

    @Operation(summary = "save review", description = "save review")
    @PostMapping("/save]{id}")
    public String save(@PathVariable(value = "id") Long id, @RequestBody ProductReviews product) {
        product.setId(id);
        productReviewRepository.update(product);
        return "sucees save product";
    }
}
