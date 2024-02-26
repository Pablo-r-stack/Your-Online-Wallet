package com.no_country.yow.controllers;

import com.no_country.yow.models.Bank;
import com.no_country.yow.services.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private IBankService service;

    /* ----- CRUD ----- */

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listOne(@PathVariable Long id){
        Optional<Bank> bankOptional = service.findById(id);
        if(bankOptional.isPresent())
            return ResponseEntity.ok(bankOptional.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Bank bank){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(bank));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Bank bank, @PathVariable Long id){
        Optional<Bank> bankOptional = service.findById(id);
        if(bankOptional.isPresent()) {
            Bank bankDb = bankOptional.get();
            bankDb.setNameBank(bank.getNameBank());
            bankDb.setServiceBank(bank.getServiceBank());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(bank));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Bank> bankOptional = service.findById(id);
        if(bankOptional.isPresent()){
            service.delete(bankOptional.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
