/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.services;

import com.no_country.yow.models.Person;
import com.no_country.yow.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpach
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public void save(Person person) {

        personRepository.save(person);

    }

}
