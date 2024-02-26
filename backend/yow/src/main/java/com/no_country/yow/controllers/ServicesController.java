package com.no_country.yow.controllers;

import com.no_country.yow.models.Services;
import com.no_country.yow.services.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private IServicesService service;

    /* ----- CRUD ----- */

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listOne(@PathVariable Long id){
        Optional<Services> servicesOptional = service.findById(id);
        if(servicesOptional.isPresent())
            return ResponseEntity.ok(servicesOptional.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Services services){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(services));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Services services, @PathVariable Long id){
        Optional<Services> servicesOptional = service.findById(id);
        if(servicesOptional.isPresent()) {
            Services servicesDb = servicesOptional.get();
            servicesDb.setNameService(services.getNameService());
            servicesDb.setAccountPerson(services.getAccountPerson());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(servicesDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Services> servicesOptional = service.findById(id);
        if(servicesOptional.isPresent()){
            service.delete(servicesOptional.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
