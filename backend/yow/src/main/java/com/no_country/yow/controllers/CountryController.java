package com.no_country.yow.controllers;

import com.no_country.yow.models.Countries;
import com.no_country.yow.services.IServiceCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private IServiceCountry serviceCountry;

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(serviceCountry.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listOne(@PathVariable Long id){
        Optional<Countries> countriesOptional = serviceCountry.findById(id);
        if(countriesOptional.isPresent())
            return ResponseEntity.ok(countriesOptional.get());
        return ResponseEntity.notFound().build();
    }
}
