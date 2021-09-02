package com.example.myapi.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("ดึงข้อมูลของ product id = 1 ได้")
    public void case1() {
        // Arrange
        Product newProduct = new Product();
        newProduct.setName("demo name");
        newProduct.setPrice(100);
        productRepository.save(newProduct);
        // Act
        Product product1 = productRepository.getById(1);
        // Assert
        assertEquals(1, product1.getId());
        assertEquals("demo name", product1.getName());
        assertEquals(100, product1.getPrice());
    }

}