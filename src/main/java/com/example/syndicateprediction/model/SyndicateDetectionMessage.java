package com.example.syndicateprediction.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SyndicateDetectionMessage {
    private String message;
    private String heading;
}
