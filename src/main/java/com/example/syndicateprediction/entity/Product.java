package com.example.syndicateprediction.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer product_id;
    @Column(unique = true)
    public String product_name;
    public Integer set_product_price;
    public Integer product_market_price;
    public Integer day;
    public Integer month;
    public Integer year;
}
