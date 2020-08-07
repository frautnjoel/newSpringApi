package com.example.demo.controller;

import com.example.demo.model.Impressions;
import com.example.demo.service.ImpressionsService;
import com.example.demo.util.locationUri;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/impressions")
public class ImpressionsController {
    ImpressionsService impressionsService;
@Autowired
    public ImpressionsController(ImpressionsService impressionsService) {
        this.impressionsService = impressionsService;
    }

    @PostMapping("/printer/{idPrinter}")
    public ResponseEntity<Impressions> write(@RequestBody Impressions impression,@PathVariable Integer idPrinter) throws Exception {
return ResponseEntity.ok(impressionsService.write(impression,idPrinter));
/*
        URI uri = locationUri.getLocation(impressionsService.write(impression,idPrinter).getId());
        return ResponseEntity.created(uri).build();
*/

    }

}
