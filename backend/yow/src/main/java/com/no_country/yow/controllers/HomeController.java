/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.controllers;

import com.no_country.yow.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Person;
import com.no_country.yow.services.PersonService;

/**
 *
 * @author jpach
 */
@RestController
@RequestMapping("/yow")
public class HomeController {


  private PersonService beanPerson;
  private CountryService beanCountry;
  public HomeController(PersonService personService, CountryService countryService) {
    this.beanPerson = personService;
    this.beanCountry = countryService;
    }


    @GetMapping("/register")
    public ResponseEntity<?> register(){

    return beanCountry.findAll();

    }


  @PostMapping("/save-register")
  public ResponseEntity<?> saveRegister(@RequestBody Person person) throws YOWException {
    System.out.println(person.toString());
    return beanPerson.save(person);

  }

  @PostMapping("/login/change-password")
  public ResponseEntity<?> changePassword(@RequestParam("numDocument") String numDocument, @RequestParam("password") String newPassword) throws YOWException {

    return beanPerson.updatePassword(numDocument,newPassword);
  }

}