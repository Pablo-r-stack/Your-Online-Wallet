/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.models;


import java.time.LocalDate;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author jpach
 */
@Entity
@Data
//@AllArgsConstructor
public class AccountMovements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amountMovements;

    @Column(nullable = false)
    private LocalDate date;

    @OneToOne //@ManyToOne
    private Services movementService;
}
