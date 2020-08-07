package com.example.demo.controller;
import com.example.demo.Exception.UserException;
import com.example.demo.Exception.ValidationException;
import com.example.demo.model.Printer;
import com.example.demo.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/printer")
public class PrinterController {
    PrinterService printerService;

@Autowired
    public PrinterController(PrinterService printerService) {
        this.printerService = printerService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Printer>> read(){
        List<Printer> foundPrinter = printerService.read();
        if (foundPrinter == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundPrinter);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Printer> write(@RequestBody Printer p){
    return ResponseEntity.ok(printerService.write(p));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Integer id) throws UserException{
        printerService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Printer> update(@RequestBody Printer student, @PathVariable Integer id)throws ValidationException {
        Printer updatedStudent = printerService.update(id, student);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedStudent);
        }
    }

}
