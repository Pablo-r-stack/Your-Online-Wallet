/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.services;

import com.no_country.yow.email.SendEmail;
import com.no_country.yow.enums.Roles;
import com.no_country.yow.exceptions.CallExceptionYOW;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Person;
import com.no_country.yow.models.VirtualWallet;
import com.no_country.yow.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import com.no_country.yow.repositories.VirtualWalletRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jpach
 */
@Slf4j
@Service
public class PersonService implements CRUDServices<Person, Long> {

    @Autowired
    private PersonRepository personRepository; 
    
    private final CallExceptionYOW valid = new CallExceptionYOW();

    @Autowired
    private VirtualWalletRepository WalletRepository;

    @Autowired
    private PasswordEncoder encrypt;
    private SendEmail sendEmail; 

    
//    public PersonService(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }

    // Método para registrar a la persona en la base de datos y crear su billetera
    @Override
    public ResponseEntity<?> save(Person person) throws YOWException {
        try {
            valid.fieldEmpty(person);
            person.setPassword(encrypt.encode(person.getPassword()));
            person.setRol(Roles.Client);
            personRepository.save(person); 
            WalletRepository.save(new VirtualWallet(0.0, person));
            return ResponseEntity.status(HttpStatus.CREATED).body(person); 
        } catch (YOWException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

   
    
//    // Método para obtener todas las personas
//    @Override
//    public ResponseEntity<List<Person>> findAll() {
//        List<Person> listPerson = personRepository.findAll(); // Devolver todas las personas almacenadas en la base de datos
//
//        return ResponseEntity.ok().body(listPerson);
//    }

    // Método para cambiar la contraseña de una persona
    @Transactional 
    public ResponseEntity<?> updatePassword(String numdocument, String newPassword) throws YOWException {
        try {
            Person person = new Person();
            ResponseEntity<?> result = findByNumberDocument(numdocument); 
            personRepository.updatePassword(numdocument, encrypt.encode(newPassword)); 

            person = (Person) result.getBody();

            sendEmail = new SendEmail(); 

            sendEmail.createEmail(person.getEmail(), newPassword); 
            sendEmail.sendEmail();

            return ResponseEntity.ok().body("Contraseña Actualizada Exitosamente"); 
        } catch (YOWException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); 
        }
    }

    public ResponseEntity<?> findByNumberDocument(String numberDocument) {

        try {
            Person person = personRepository.findByNumberDocument(numberDocument);
            valid.isUserExist(person);

            return ResponseEntity.ok().body(person);

        } catch (YOWException e) {
            log.error("Error: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @Override
    public ResponseEntity<List<Person>> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResponseEntity<?> updateById(Person t, Long id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResponseEntity<?> findById(Long id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
