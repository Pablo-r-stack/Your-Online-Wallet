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

    if (person.getNumberIdentification() == null) {
      throw new YOWException("Completa los campos correctamente");

    }
    
  }
    
    
}
