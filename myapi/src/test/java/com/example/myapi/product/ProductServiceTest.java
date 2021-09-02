package com.example.myapi.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("Success case")
    public void case01() {
        // Arrange
        Product product = new Product();
        product.setId(1);
        product.setName("Test with mockito");
        when(productRepository.getById(1)).thenReturn(product);

        ProductService service = new ProductService(productRepository);
        // Act
        ProductResponse result = service.getById(1);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("Test with mockito", result.getProductName());
    }
}