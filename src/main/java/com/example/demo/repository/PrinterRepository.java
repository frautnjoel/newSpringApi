package com.example.demo.repository;

import com.example.demo.model.Printer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrinterRepository extends JpaRepository<Printer,Integer> {

/*
    @Query(value = "update printer u set u.active = false where u.id = ?1", nativeQuery = true)
    void delete(Integer idUser);*/

    @Query(value = "update printer u set u.brand = ?1, u.model = ?2, u.os = ?3 where u.id = ?4", nativeQuery = true)
      Printer updatePRinter(String brand, String model, String os,Integer id);
}
