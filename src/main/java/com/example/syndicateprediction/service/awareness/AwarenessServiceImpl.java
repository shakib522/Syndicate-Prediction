package com.example.syndicateprediction.service.awareness;


import com.example.syndicateprediction.entity.Awareness;
import com.example.syndicateprediction.model.SyndicateDetectionMessage;
import com.example.syndicateprediction.repository.AwarenessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AwarenessServiceImpl implements AwarenessService {

    private final AwarenessRepository awarenessRepository;

    @Override
    public Awareness createAwareness(Awareness awareness) {
        return awarenessRepository.save(awareness);
    }

    @Override
    public List<Awareness> getAllAwareness() {
        return awarenessRepository.findAll();
    }

    @Override
    public SyndicateDetectionMessage syndicateDetection() {
        return SyndicateDetectionMessage.builder().message("Possible egg price manipulation  in Saheb Bajar,Rajshahi.Please take necessary steps").heading("Possible Syndicate of Egg in this month").build();
    }
}
