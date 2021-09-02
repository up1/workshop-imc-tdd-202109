package com.example.myapi.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public ProductResponse getById(int id) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(id);
        productResponse.setProductName("พัดลม");
        productResponse.setPrice(1200);
        return productResponse;
    }
}
