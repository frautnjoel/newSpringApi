package com.example.demo.service;

import com.example.demo.model.Impressions;
import com.example.demo.model.Printer;
import com.example.demo.repository.ImpressionsRepository;
import com.example.demo.repository.PrinterRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ImpressionServiceTest {

    ImpressionsService service;

    @Mock
    ImpressionsRepository dao;
    @Mock
    PrinterRepository daoprinter;

    @Before
    public void setUp() {
        initMocks(this);
        service = new ImpressionsService(dao,daoprinter);
    }

    @Test
    public void testreadOk() throws Exception {

        Impressions e=createImpressions();
        Printer p=createPrinter();
        when(dao.save(e)).thenReturn(e);



    }


    private Impressions createImpressions() {
        Printer p=createPrinter();
        return Impressions.builder().id(1).name("a").weight("a").printer(p).build();
    }

    private Printer createPrinter() {
        return Printer.builder().id(1).brand("aa").model("b").os("os").impressions(new ArrayList<>()).build();
    }

}
