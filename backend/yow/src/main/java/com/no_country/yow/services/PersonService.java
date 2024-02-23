/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.services;

import com.no_country.yow.exceptions.CallExceptionYOW;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Person;
import com.no_country.yow.repositories.PersonRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpach
 */
@Service
// @Slf4j
public class PersonService implements CRUDServices<Person> {

  @Autowired
  private PersonRepository personRepository;
  private CallExceptionYOW valid = new CallExceptionYOW();

  @SuppressWarnings("null")
  @Override
  public ResponseEntity<?> save(Person person) throws YOWException {

    try {

      valid.fieldEmpty(person);
      personRepository.save(person);

      return ResponseEntity.status(HttpStatus.CREATED).body(person);

    } catch (YOWException e) {

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }
  }

  @Override
  public List<Person> findAll() {
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public ResponseEntity<?> updateById(Long id) throws YOWException {
    throw new UnsupportedOperationException("Unimplemented method 'updateById'");
  }

  @Override
  public ResponseEntity<?> findById(Long id) throws YOWException {
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

}
