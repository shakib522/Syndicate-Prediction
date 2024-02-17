package com.example.syndicateprediction.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Awareness {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer awareness_id;
    public String heading;
    public String description;
}
