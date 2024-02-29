package com.no_country.yow.controllers;

import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Person;
import com.no_country.yow.models.VirtualWallet;
import com.no_country.yow.services.PersonService;
import com.no_country.yow.services.VirtualWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/virtual-wallet")
public class VirtualWalletController {

    @Autowired
    private VirtualWalletService virtualWalletService;

    @Autowired
    private PersonService personService;

    // Se especifica el id del usuario al que se le quiere agregar la billetera y se le pasa su saldo inicial por medio
    // de un json
    @PostMapping("/{id}") // Id del usuario
    public ResponseEntity<?> create(@RequestBody VirtualWallet virtualWallet, @PathVariable Long id) throws YOWException {
        Person person = (Person) personService.findById(id).getBody();
        if(person != null){
            person.addVirtualWallet(virtualWallet); // Se guarda la billetera dentro del usuario
            return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
        }
        return ResponseEntity.notFound().build(); // Si no encuentra el id del usuario retorna un not found
    }

}
