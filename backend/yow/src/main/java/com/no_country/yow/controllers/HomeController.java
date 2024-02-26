/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.no_country.yow.exceptions.CallExceptionYOW;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Person;
import com.no_country.yow.services.PersonService;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author jpach
 */
@RestController
@RequestMapping("/yow")
// @Slf4j
public class HomeController {

  @Autowired
  private PersonService beanPerson;


  public HomeController(PersonService personService) {
    this.beanPerson = personService;
    }


/*    @PostMapping("/login")
    public ResponseEntity<?> login(){

    return ResponseEntity.ok("Hoala");
    }*/

    /*Endpoint de registro de usuario*/
  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody Person person) throws YOWException {

    return beanPerson.save(person);

  }

  @PostMapping("/change-password")
  public ResponseEntity<?> changePassword(@RequestParam("numDocument") String numDocument, @RequestParam("password") String newPassword) throws YOWException {

    return beanPerson.changePassword(numDocument,newPassword);
  }




}
