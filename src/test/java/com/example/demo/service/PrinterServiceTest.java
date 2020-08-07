package com.example.demo.service;

import com.example.demo.model.Printer;
import com.example.demo.repository.PrinterRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PrinterServiceTest {

    PrinterService service;

    @Mock
    PrinterRepository dao;

    @Before
    public void setUp() {
        initMocks(this);
        service = new PrinterService(dao);
    }

    @Test
    public void testreadOk(){
        when(dao.findAll()).thenReturn(new ArrayList<Printer>());
        Assert.assertEquals(new ArrayList<Printer>(),service.read());
    }
}
