package com.example.syndicateprediction.service.productService;


import com.example.syndicateprediction.entity.Product;
import com.example.syndicateprediction.error.DefaultException;
import com.example.syndicateprediction.error.DefaultMessage;
import com.example.syndicateprediction.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public DefaultMessage createProduct(Product product) throws DefaultException {
        if (productRepository.findByProductName(product.product_name).isPresent()){
            throw new DefaultException("Product already exists", 409);
        }
        productRepository.save(product);
        return DefaultMessage.builder().message("Product created").statusCode(201).status("Success").build();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
