package com.no_country.yow.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import lombok.NonNull;

@Entity
@Data
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP) // Fecha y hora
    @NonNull
    private Date date;

    @NonNull
    private Double mount;
    @NonNull
    private Boolean successful; // Si el movimiento fue exitoso

    @ManyToOne
    @JoinColumn(name = "service_id")
    @NonNull
    private Services services;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    @NonNull
    private VirtualWallet wallet;
}
