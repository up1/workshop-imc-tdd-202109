package com.example.myapi.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;
// 1. Start server
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerSpringBootTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void getProductDetail() {
        // Arrange
        Product newProduct = new Product();
        newProduct.setName("พัดลม");
        newProduct.setPrice(1200);
        productRepository.save(newProduct);

        // 2. Call to /products/1
        ProductResponse productResponse
                = restTemplate.getForObject("/products/1", ProductResponse.class);
        // 3. Assert result with expected result
        assertEquals(1, productResponse.getId());
        assertEquals("พัดลม", productResponse.getProductName());
        assertEquals(1200, productResponse.getPrice());

        ProductResponse expected = new ProductResponse();
        expected.setId(1);
        expected.setProductName("พัดลม");
        expected.setPrice(1200);
        assertEquals(expected, productResponse);
    }
}