package com.example.demo;

import com.example.demo.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private ProductController productController;

	@Test
	void contextLoads() {

	}

}
