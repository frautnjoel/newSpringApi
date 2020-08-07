package com.example.demo.controller;

import com.example.demo.model.Impressions;
import com.example.demo.model.Printer;
import com.example.demo.service.PrinterService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PrinterControllerTest {

    PrinterController printerController;
    PrinterService service;


    @Before
    public void setUp() {
        service = mock(PrinterService.class);
        printerController = new PrinterController(service);
    }

    @Test
    public void readTest(){
        Printer p=createPrinter();
        List<Printer> list=new ArrayList<>();
        list.add(p);
        when(service.read()).thenReturn(list);
        ResponseEntity<List<Printer>> expected=ResponseEntity.ok(service.read());
        ResponseEntity<List<Printer>> result=printerController.read();
        Assert.assertEquals(expected,result);
    }

    private Printer createPrinter() {
        return Printer.builder().brand("aa").model("b").os("os").impressions(new ArrayList<>()).build();
    }

}
