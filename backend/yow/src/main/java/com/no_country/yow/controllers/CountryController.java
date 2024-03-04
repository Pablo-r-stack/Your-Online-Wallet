package com.no_country.yow.controllers;


import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping
    public ResponseEntity<?> list(){
        return service.findAll();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> listOne(@PathVariable Long id) throws YOWException {
//        return service.findById(id);
//    }
}
