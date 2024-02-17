package com.example.syndicateprediction.service.productService;


import com.example.syndicateprediction.entity.Product;
import com.example.syndicateprediction.error.DefaultException;
import com.example.syndicateprediction.error.DefaultMessage;
import com.example.syndicateprediction.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public DefaultMessage editProduct(Product product, Integer productId) {
        Optional<Product> productOptional = productRepository.findByProductId(productId);
        if (productOptional.isEmpty()){
            throw new DefaultException("Product not found", 404);
        }

        Product product1 = productOptional.get();
        product1.setProduct_name(product.getProduct_name());
        product1.setSet_product_price(product.getSet_product_price());
        product1.setProduct_market_price(product.getProduct_market_price());
         productRepository.save(product1);
         return DefaultMessage.builder().message("Product updated").statusCode(200).status("Success").build();
    }
}
