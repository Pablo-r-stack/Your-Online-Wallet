/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.models;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
/**
 *
 * @author jpach
 */
@Entity
@Data
public class Service {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false , unique = true)
    private String nameService;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "movement_id")
    private List<Movement> movements;

    public Service() {
        this.movements = new ArrayList<>();
    }

    public void addMovements(Movement movements){
        this.movements.add(movements);
    }

}
