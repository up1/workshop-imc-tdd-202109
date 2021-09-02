package com.example.myapi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse getById(int id) {
        Product product = productRepository.getById(id);
        // Map entity to response object
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setProductName(product.getName());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }
}
