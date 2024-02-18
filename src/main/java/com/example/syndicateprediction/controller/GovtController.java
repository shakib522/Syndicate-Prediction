package com.example.syndicateprediction.controller;

import com.example.syndicateprediction.entity.Awareness;
import com.example.syndicateprediction.entity.Product;
import com.example.syndicateprediction.error.DefaultException;
import com.example.syndicateprediction.error.DefaultMessage;
import com.example.syndicateprediction.model.ProductRequest;
import com.example.syndicateprediction.model.SyndicateDetectionMessage;
import com.example.syndicateprediction.service.awareness.AwarenessService;
import com.example.syndicateprediction.service.productService.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/v1/govt")
public class GovtController {

    private final ProductService productService;
    private final AwarenessService awarenessService;

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

    @PutMapping("/editProduct/{product_name}")
    public ResponseEntity<DefaultMessage> editProduct(@RequestBody ProductRequest productRequest,@PathVariable String product_name) throws DefaultException {
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
        return ResponseEntity.status(201).body(productService.editProduct(product,product_name));
    }

    @PostMapping("/awareness")
    public ResponseEntity<Awareness> createAwareness(@RequestBody Awareness awareness){
        return ResponseEntity.status(201).body(awarenessService.createAwareness(awareness));
    }

    @GetMapping("/getSyndicateDetection")
    public ResponseEntity<SyndicateDetectionMessage> syndicateDetection(){
        return ResponseEntity.status(200).body(awarenessService.syndicateDetection());
    }

}
