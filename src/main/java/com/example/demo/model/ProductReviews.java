package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class ProductReviews {

    private Long id;
    private Long productid;
    private Float rating;
    private String reviews_comment;
    private Date create_date;
}
