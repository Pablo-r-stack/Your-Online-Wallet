/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.models;



import javax.persistence.*;

import lombok.Data;
/**
 *
 * @author jpach
 */
@Entity
@Data
public class Services{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false , unique = true)
    private String service;
    
    
}
