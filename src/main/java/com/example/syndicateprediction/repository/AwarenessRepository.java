package com.example.syndicateprediction.repository;


import com.example.syndicateprediction.entity.Awareness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwarenessRepository extends JpaRepository<Awareness, Integer> {
}
