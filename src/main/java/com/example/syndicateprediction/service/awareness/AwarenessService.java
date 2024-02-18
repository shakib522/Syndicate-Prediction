package com.example.syndicateprediction.service.awareness;


import com.example.syndicateprediction.entity.Awareness;
import com.example.syndicateprediction.model.SyndicateDetectionMessage;

import java.util.List;

public interface AwarenessService {

    Awareness createAwareness(Awareness awareness);

    List<Awareness> getAllAwareness();

    SyndicateDetectionMessage syndicateDetection();
}
