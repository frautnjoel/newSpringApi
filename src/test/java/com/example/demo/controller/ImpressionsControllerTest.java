package com.example.demo.controller;

import com.example.demo.model.Impressions;
import com.example.demo.model.Printer;
import com.example.demo.service.ImpressionsService;
import com.example.demo.service.PrinterService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ImpressionsControllerTest {

  ImpressionsController impressionsController;
    ImpressionsService service;


    @Before
    public void setUp() {
        service = mock(ImpressionsService.class);
        impressionsController = new ImpressionsController(service);
    }
    @Test
    public void writeTest()throws Exception{
        Impressions i=createImpressions();
        Printer p=createPrinter();
        when(service.write(new Impressions(1,"b","b",p),1)).thenReturn(i);
        Impressions expected = service.write( new Impressions(1, "b", "b",p),1);
        ResponseEntity<Impressions> result = impressionsController.write( new Impressions(1, "b", "b", p),1);
        Assert.assertEquals(ResponseEntity.ok(expected),result);

    }

    private Impressions createImpressions() {
        Printer p=createPrinter();
        return Impressions.builder().id(1).name("a").weight("a").printer(p).build();
    }

    private Printer createPrinter() {
        return Printer.builder().brand("printerBrand").model("printerModel").os("printerOos").impressions(new ArrayList<>()).build();
    }

}
