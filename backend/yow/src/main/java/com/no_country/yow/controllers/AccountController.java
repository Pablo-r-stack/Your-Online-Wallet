package com.no_country.yow.controllers;

import com.no_country.yow.models.Account;
import com.no_country.yow.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService service;

    /* ----- CRUD ----- */

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listOne(@PathVariable String id){
        Optional<Account> accountOptional = service.findById(id);
        if(accountOptional.isPresent())
            return ResponseEntity.ok(accountOptional.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Account account){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Account account, @PathVariable String id){
        Optional<Account> accountOptional = service.findById(id);
        if(accountOptional.isPresent()){
            Account accountDb = accountOptional.get();
            accountDb.setBalance(account.getBalance());
            accountDb.setPerson(account.getPerson());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(accountDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        Optional<Account> accountOptional = service.findById(id);
        if(accountOptional.isPresent()){
            service.delete(accountOptional.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
