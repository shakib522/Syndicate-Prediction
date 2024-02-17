package com.example.syndicateprediction.repository;

import com.example.syndicateprediction.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.product_name = ?1")
    Optional<Product> findByProductName(String product_name);

    @Query("SELECT p FROM Product p WHERE p.product_id = ?1")
    Optional<Product> findByProductId(Integer product_id);
}
