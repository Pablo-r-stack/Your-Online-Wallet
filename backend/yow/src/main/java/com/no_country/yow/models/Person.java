/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.no_country.yow.enums.Roles;

import lombok.Data;

/**
 *
 * @author jpach
 */
@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String numberIdentification;
    @Email
    @Size(max = 80)
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToOne
    private Country country;

    @Enumerated(EnumType.STRING)
    private Roles rol;
    
    // Falta el documento de validación

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "virtual_id")
    private VirtualWallet virtualWallet;

    public Person() {
        this.virtualWallet = null;
    }

    public void addVirtualWallet(VirtualWallet virtualWallet){
        this.virtualWallet = virtualWallet;
    }
}
