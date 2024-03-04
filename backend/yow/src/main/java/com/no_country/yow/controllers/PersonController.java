//package com.no_country.yow.controllers;
//
//import com.no_country.yow.exceptions.YOWException;
//import com.no_country.yow.models.Person;
//import com.no_country.yow.services.PersonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/user")
//public class PersonController {
//
//    @Autowired
//    private PersonService service;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findUserById(@PathVariable Long id) throws YOWException {
//        return service.findById(id);
//    }
//
//    @PutMapping("/modifiedUser/{id}")
//    public ResponseEntity<?> updatePassword(@RequestBody Person person, @PathVariable Long id) throws YOWException {
//        return service.updateById(person, id);
//    }
//}
