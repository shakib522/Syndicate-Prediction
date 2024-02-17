package com.example.syndicateprediction.service.productService;


import com.example.syndicateprediction.entity.Product;
import com.example.syndicateprediction.error.DefaultException;
import com.example.syndicateprediction.error.DefaultMessage;

import java.util.List;

public interface ProductService {
    DefaultMessage createProduct(Product product) throws DefaultException;

    List<Product> getAllProducts();

    DefaultMessage editProduct(Product product, Integer productId);
}
