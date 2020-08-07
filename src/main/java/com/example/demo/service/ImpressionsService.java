package com.example.demo.service;

import com.example.demo.model.Impressions;
import com.example.demo.repository.ImpressionsRepository;
import com.example.demo.repository.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ImpressionsService {
    ImpressionsRepository impressionsRepository;
    PrinterRepository printerRepository;

    @Autowired
    public ImpressionsService(ImpressionsRepository impressionsRepository, PrinterRepository printerRepository) {
        this.impressionsRepository = impressionsRepository;
        this.printerRepository = printerRepository;
    }




    public Impressions write(Impressions impressions,Integer idPrinter) throws Exception {

                   return printerRepository.findById(idPrinter).map(p -> {
            impressions.setPrinter(p);
            return impressionsRepository.save(impressions);
        }).orElseThrow(() -> new Exception());


    }
}
