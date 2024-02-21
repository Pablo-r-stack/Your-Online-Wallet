/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.exceptions;

/**
 *Clase de Excepciones 
 * @author jpach
 */
public class YOWException extends Exception {

    /*serialVersionUID es importante para asegurar que los objetos serializados puedan deserializarse correctamente,
    incluso si la clase ha cambiado entre la serialización y la deserialización.*/
    public static final long serialVersionUID = 700L;

    public YOWException(String message) {
        super(message);
    }

}
