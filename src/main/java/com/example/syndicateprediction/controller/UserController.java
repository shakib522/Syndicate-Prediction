package com.example.syndicateprediction.controller;


import com.example.syndicateprediction.entity.Awareness;
import com.example.syndicateprediction.entity.Product;
import com.example.syndicateprediction.service.awareness.AwarenessService;
import com.example.syndicateprediction.service.productService.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    private final ProductService productService;
    private final AwarenessService awarenessService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @GetMapping("/getAllAwareness")
    public ResponseEntity<List<Awareness>> getAllAwareness(){
        return ResponseEntity.status(200).body(awarenessService.getAllAwareness());
    }
}
