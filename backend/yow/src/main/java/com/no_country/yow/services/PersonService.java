/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.services;

import com.no_country.yow.dto.AccountDTO;
import com.no_country.yow.email.SendEmail;
import com.no_country.yow.exceptions.CallExceptionYOW;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Person;
import com.no_country.yow.repositories.PersonRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jpach
 */
@Service
@Slf4j
public class PersonService implements CRUDServices<Person, Long> {


    private final PersonRepository personRepository; // Repositorio para acceder a la capa de persistencia de personas
    private final CallExceptionYOW valid = new CallExceptionYOW(); // Instancia de una clase que maneja excepciones específicas

    @Autowired
    private PasswordEncoder encrypt;
    private SendEmail sendEmail; // Instancia de la clase SendEmail para enviar correos electrónicos

    // Constructor que recibe un repositorio de personas como argumento
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository; // Inicialización del repositorio de personas
    }

    // Método para guardar una persona en la base de datos
    @Override
    public ResponseEntity<?> save(Person person) throws YOWException {
        try {
            valid.fieldEmpty(person); // Validar campos vacíos de la persona
            person.setPassword(encrypt.encode(person.getPassword()));
            personRepository.save(person); // Guardar la persona en la base de datos
            return ResponseEntity.status(HttpStatus.CREATED).body(person); // Devolver respuesta exitosa con la persona guardada
        } catch (YOWException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); // Manejar excepción en caso de error
        }
    }

    // Método para obtener todas las personas
    @Override
    public List<Person> findAll() {
        return personRepository.findAll(); // Devolver todas las personas almacenadas en la base de datos
    }

    // Método para actualizar una persona por su ID (no implementado)
    @Override
    public ResponseEntity<?> updateById(Person person, Long id) throws YOWException {
        Optional<Person> personOptional = personRepository.findById(id);
        if(personOptional.isPresent()){
            Person personUpdate = personOptional.get();
            personUpdate.setName(person.getName());
            personUpdate.setLastName(person.getLastName());
            personUpdate.setNumberIdentification(person.getNumberIdentification());
            personUpdate.setEmail(person.getEmail());
            personUpdate.setPassword(person.getPassword());
            personUpdate.setCountry(person.getCountry());
            personUpdate.setRol(person.getRol());
            personUpdate.setVirtualWallet(person.getVirtualWallet());
            return ResponseEntity.status(HttpStatus.CREATED).body(personRepository.save(personUpdate));
        }
        return ResponseEntity.notFound().build();
    }

    // Método para buscar una persona por su ID (no implementado)
    @Override
    public ResponseEntity<?> findById(Long id) throws YOWException {
        throw new UnsupportedOperationException("Unimplemented method 'findById'"); // Lanzar excepción de operación no implementada
    }

    // Método para cambiar la contraseña de una persona
    @Transactional // Anotación para indicar que este método requiere una transacción
    public ResponseEntity<?> updatePassword(String numdocument, String newPassword) throws YOWException {
        try {
            Person person = new Person();
            ResponseEntity<?> result =  findByNumberDocument(numdocument); // Buscar una persona por su número de documento
            personRepository.updatePassword(numdocument, encrypt.encode(newPassword)); // Actualizar la contraseña de la persona en la base de datos

            person = (Person) result.getBody();

            sendEmail = new SendEmail(); // Inicializar una instancia de SendEmail

            sendEmail.createEmail(person.getEmail(), newPassword); // Crear y configurar un correo electrónico para notificar el cambio de contraseña
            sendEmail.sendEmail(); // Enviar el correo electrónico

            return ResponseEntity.ok().body("Contraseña Actualizada Exitosamente"); // Devolver respuesta exitosa
        } catch (YOWException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // Manejar excepción en caso de error
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

    public AccountDTO mainSection(String numberDocument){

        return null;
    }


}
