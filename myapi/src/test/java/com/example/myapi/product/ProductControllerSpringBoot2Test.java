package com.example.myapi.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

// 1. Start server
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerSpringBoot2Test {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void getProductDetail() {
        // Arrange
        Product newProduct = new Product();
        newProduct.setId(1);
        newProduct.setName("พัดลม");
        newProduct.setPrice(1200);
        when(productRepository.getById(1)).thenReturn(newProduct);

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