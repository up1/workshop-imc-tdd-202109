package com.example.myapi.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products/{id}")
    public ProductResponse getProductDetail(@PathVariable String id) {
        return new ProductResponse();
    }

}
