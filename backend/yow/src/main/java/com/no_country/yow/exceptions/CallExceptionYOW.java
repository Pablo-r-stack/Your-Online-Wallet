/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.exceptions;

import com.no_country.yow.models.Person;

/**
 *
 * @author jpach
 */
public class CallExceptionYOW {

    public CallExceptionYOW() {
    }

    public void fieldEmpty(Person person) throws YOWException {

        if (person.getName().trim().isEmpty()
                || person.getLastName().trim().isEmpty()
                || person.getNumberIdentification() == null
                || person.getEmail().trim().isEmpty()
                || person.getPassword().trim().isEmpty()
                || person.getCountry().getId() <= 0) {
            throw new YOWException("Completa los campos correctamente");

        }

    }

}
