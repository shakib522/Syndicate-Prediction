package com.example.syndicateprediction.controller;

import com.example.syndicateprediction.entity.Product;
import com.example.syndicateprediction.error.DefaultException;
import com.example.syndicateprediction.error.DefaultMessage;
import com.example.syndicateprediction.model.ProductRequest;
import com.example.syndicateprediction.service.productService.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/v1/govt")
public class GovtController {

    private final ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<DefaultMessage> createProduct(@RequestBody ProductRequest productRequest) throws DefaultException {
        val day= LocalDateTime.now().getDayOfMonth();
        val month=LocalDateTime.now().getMonthValue();
        val year=LocalDateTime.now().getYear();
        Product product = Product.builder()
                .product_name(productRequest.product_name)
                .set_product_price(productRequest.set_product_price)
                .product_market_price(productRequest.product_market_price)
                .day(day)
                .month(month)
                .year(year)
                .build();
        return ResponseEntity.status(201).body(productService.createProduct(product));
    }



}
