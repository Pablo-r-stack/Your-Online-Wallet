package com.no_country.yow.controllers;

import com.no_country.yow.models.AccountMovements;
import com.no_country.yow.services.IAccountMovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account-movements")
public class AccountMovementController {

    @Autowired
    private IAccountMovementsService service;

    /* ----- CRUD ----- */

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listOne(@PathVariable Long id){
        Optional<AccountMovements> accountMovementsOptional = service.findById(id);
        if(accountMovementsOptional.isPresent())
            return ResponseEntity.ok(accountMovementsOptional.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AccountMovements accountMovements){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(accountMovements));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AccountMovements accountMovements, @PathVariable Long id){
        Optional<AccountMovements> accountMovementsOptional = service.findById(id);
        if(accountMovementsOptional.isPresent()){
            AccountMovements accountMovementsDb = accountMovementsOptional.get();
            accountMovementsDb.setAmountMovements(accountMovements.getAmountMovements());
            accountMovementsDb.setDate(accountMovements.getDate());
            accountMovementsDb.setMovementService(accountMovements.getMovementService());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(accountMovementsDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<AccountMovements> accountMovementsOptional = service.findById(id);
        if(accountMovementsOptional.isPresent()){
            service.delete(accountMovementsOptional.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
