package com.no_country.yow.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class PersonController {

    @PutMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@PathVariable("document") Long document){


        return ResponseEntity.ok("");

    }
}
