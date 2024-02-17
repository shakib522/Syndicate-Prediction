package com.example.syndicateprediction.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    public String product_name;
    public Integer set_product_price;
    public Integer product_market_price;
}
