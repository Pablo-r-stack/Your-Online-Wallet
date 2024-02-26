package com.no_country.yow.controllers;

import com.no_country.yow.models.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class PersonController {

    @PutMapping("/modifiedUser")
    public ResponseEntity<?> updatePassword(@RequestBody Person person){


        return ResponseEntity.ok("");

    }
}
