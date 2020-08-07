package com.example.demo.repository;

import com.example.demo.model.Impressions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpressionsRepository extends JpaRepository<Impressions,Integer> {
}
