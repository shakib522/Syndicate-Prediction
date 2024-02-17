package com.example.syndicateprediction.service.awareness;


import com.example.syndicateprediction.entity.Awareness;

import java.util.List;

public interface AwarenessService {

    public Awareness createAwareness(Awareness awareness);

    List<Awareness> getAllAwareness();
}
