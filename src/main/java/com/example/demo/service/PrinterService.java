package com.example.demo.service;

import com.example.demo.Exception.UserException;
import com.example.demo.Exception.ValidationException;
import com.example.demo.model.Printer;
import com.example.demo.repository.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrinterService {

    PrinterRepository printerRepository;
@Autowired
    public PrinterService(PrinterRepository printerRepository) {
        this.printerRepository = printerRepository;
    }

public List<Printer> read() {
return printerRepository.findAll();

}

    public Printer write(Printer p) {
    return printerRepository.save(p);
    }


    public void delete(Integer idPrinter) throws UserException {

    //printerRepository.delete(idPrinter);
    }

    public Printer update(Integer id, Printer student)throws ValidationException {
        Printer old = this.printerRepository.findById(id).get();

        if(old!=null) {
                return  printerRepository.updatePRinter(student.getBrand(),student.getModel(),student.getOs(),id);
            }
        else
        {
            throw new ValidationException("Printer type is not valid");
        }

    }
}
