package com.example.demo.repository;

import com.example.demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    Logger logger = LoggerFactory.getLogger(getClass());
    private final BeanPropertyRowMapper<Product> beanmapper = BeanPropertyRowMapper.newInstance(Product.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Product product) {
        return jdbcTemplate.update("INSERT INTO product (title, description, category, etalase, images, weight, price, sku) values (?,?,?,?,?,?,?,?)",
                product.getTitle(), product.getDescription(), product.getCategory(), product.getEtalase(), product.getImages(), product.getWeight(), product.getPrice(), product.getSku());
    }

    @Override
    public int update(Product product) {
        return jdbcTemplate.update("UPDATE product SET title=?, description=?, category=?, etalase=?, images=?, weight=?, price=?, sku=? WHERE id=?",
                product.getTitle(), product.getDescription(), product.getCategory(), product.getEtalase(), product.getImages(), product.getWeight(), product.getPrice(), product.getSku(), product.getId());
    }

    @Override
    public Product findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM product WHERE id=?", beanmapper, id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM product WHERE sku=?", id);
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM product", beanmapper);
    }

    @Override
    public List<Product> search(String criteria, String value, String sort) {
        StringBuilder query = new StringBuilder("SELECT * FROM product ");
        if(criteria.equals("sku"))
            query.append("WHERE sku ilike ? ");
        else if(criteria.equals("title"))
            query.append("WHERE title ilike ? ");
        else if(criteria.equals("category"))
            query.append("WHERE category ilike ? ");
        else if(criteria.equals("title"))
            query.append("WHERE etalase ilike ? ");
        query.append("ORDER BY ").append(sort);
        logger.info("query search : {}, value : {}", query, value);
        return jdbcTemplate.query(query.toString(), beanmapper, "%"+value+"%");
    }

    @Override
    public List<Product> searchByRating(String sort) {
        StringBuilder query = new StringBuilder("SELECT * FROM product ");
        if(sort != null)
            query.append("WHERE id in (SELECT DISTINCT a.productid FROM (SELECT productid, rating FROM product_reviews ORDER BY ").append(sort).append(") a)");
        logger.info("sort rating search : {}", query);
        return jdbcTemplate.query(query.toString(), beanmapper);
    }
}
