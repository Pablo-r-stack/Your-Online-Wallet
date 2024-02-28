package com.no_country.yow.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Movements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP) // Fecha y hora
    private Date date;

    private Double mount;
    private String reference;
    private Boolean successful; // Si el movimiento fue exitoso
}
