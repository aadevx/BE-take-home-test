package com.example.demo.repository;

import com.example.demo.model.ProductReviews;

import java.util.List;

public interface ProductReviewRepository {

    int save(ProductReviews review);

    int update(ProductReviews review);

    ProductReviews findById(Long id);

    int deleteById(Long id);

    List<ProductReviews> findAll();
}
