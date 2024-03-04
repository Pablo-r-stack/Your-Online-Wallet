/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.exceptions;

import com.no_country.yow.models.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author jpach
 */

@Slf4j
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

    public void noFound(Person person, String numdocument, String newPassword) throws YOWException {

        if (person == null) {
            throw new YOWException("No se ha encontrado coincidencia para el documento: " + numdocument);
        } else if (newPassword.trim().isEmpty() || newPassword.length() <= 10) {
            throw new YOWException("Ingrese una contraseña valida, con 10 caracteres minimo");


        }
    }

    public void isUserExist(Person person) throws YOWException {

         if (person == null) {
            throw new YOWException("No se ha encontrado coincidencia para el usuario");
        }
    }


}
