package com.example.myapi.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getProductDetail() throws Exception {
        // Arrange
        ProductResponse mockResult = new ProductResponse();
        mockResult.setId(1000);
        mockResult.setProductName("ทดสอบ");
        mockResult.setPrice(3000);
        when(productService.getById(1)).thenReturn(mockResult);

        // Act
        MvcResult result =
                mvc.perform(get("/products/1")).andExpect(status().isOk())
                        .andReturn();
        String resultJson = result.getResponse().getContentAsString();
        // Convert from string json to java object
        ObjectMapper mapper = new ObjectMapper();
        ProductResponse productResponse =
                mapper.readValue(resultJson, ProductResponse.class);
        // Assert
        ProductResponse expected = new ProductResponse();
        expected.setId(1000);
        expected.setProductName("ทดสอบ");
        expected.setPrice(3000);

        assertEquals(1000, productResponse.getId());
        assertEquals(3000, productResponse.getPrice());
        assertEquals("ทดสอบ", productResponse.getProductName());

    }
}