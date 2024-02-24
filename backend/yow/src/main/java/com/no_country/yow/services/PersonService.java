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
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpach
 */
@Service
@Slf4j
public class PersonService implements CRUDServices<Person> {


  private final PersonRepository personRepository;
  private final CallExceptionYOW valid = new CallExceptionYOW();

  public PersonService(PersonRepository personRepositoryMock) {
    this.personRepository = personRepositoryMock;
  }


  /*En este metodo nos permite insertar el registro del cliente en la base de datos*/
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
    return personRepository.findAll();
  }

  @Override
  public ResponseEntity<?> updateById(Long id) throws YOWException {
    throw new UnsupportedOperationException("Unimplemented method 'updateById'");
  }

  @Override
  public ResponseEntity<?> findById(Long id) throws YOWException {
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }


  /*Realizamos un busqueda en la tabla persona donde nos devuelve el registro por el numero del documento si se encuentra
  * se procede actualizar los datos solicitados*/

  @Transactional
  public ResponseEntity<?> changePassword(Long numdocument, String newPassword) throws YOWException{
    try {
      Optional<Person> optPerson = Optional.ofNullable(personRepository.findByNumberDocument(numdocument));
      valid.noFound(optPerson,numdocument,newPassword);

      personRepository.updatePassword(numdocument,newPassword);


    return ResponseEntity.ok().body("Contraseña Actualizada Exitosamente");
    }catch (YOWException e){

      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

    }


  }


}
