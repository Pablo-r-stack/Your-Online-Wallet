/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.no_country.yow.exceptions.CallExceptionYOW;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Person;
import com.no_country.yow.services.PersonService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;

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

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody Person person) throws YOWException {

    return beanPerson.save(person);

  }
}
