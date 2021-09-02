package com.example.myapi.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerSpringBootTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getProductDetail() {
        // 2. Call to /products/1
        ProductResponse productResponse
                = restTemplate.getForObject("/products/1", ProductResponse.class);
        // 3. Assert result with expected result
        assertEquals(1, productResponse.getId());
        assertEquals("พัดลม", productResponse.getProductName());
        assertEquals(1200, productResponse.getPrice());
    }
}