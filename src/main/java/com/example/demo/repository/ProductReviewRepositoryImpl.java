package com.example.demo.repository;

import com.example.demo.model.ProductReviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductReviewRepositoryImpl implements ProductReviewRepository {

    private final BeanPropertyRowMapper<ProductReviews> beanmapper = BeanPropertyRowMapper.newInstance(ProductReviews.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(ProductReviews review) {
        return jdbcTemplate.update("INSERT INTO product_reviews(productid, rating, review_comment) VALUES (?,?,?)",
                review.getProductid(), review.getRating(), review.getReviews_comment());
    }

    @Override
    public int update(ProductReviews review) {
        return jdbcTemplate.update("UPDATE product_reviews SET productid=?, rating=?, review_comment=? WHERE id=?",
                review.getProductid(), review.getRating(), review.getReviews_comment(), review.getId());
    }

    @Override
    public ProductReviews findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM product_reviews WHERE id=?", beanmapper, id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM product_reviews WHERE id=?", id);
    }

    @Override
    public List<ProductReviews> findAll() {
        return jdbcTemplate.query("SELECT * FROM product_reviews", beanmapper);
    }
}
