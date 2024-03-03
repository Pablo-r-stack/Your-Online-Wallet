package com.no_country.yow.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP) // Fecha y hora
    private Date date;

    private Double mount;
    private Boolean successful; // Si el movimiento fue exitoso

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private VirtualWallet wallet;
}
