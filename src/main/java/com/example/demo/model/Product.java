package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Product {

    private Long id;
    private String sku;
    private String title;
    private String description;
    private String category;
    private String etalase;
    private String images;
    private String weight;
    private Double price;
    private Date create_date;
}
