package com.no_country.yow.models;

import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;

import java.util.concurrent.atomic.AtomicLong;

@Entity
@Data
public class VirtualWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true, nullable = false)
    private String numberAccount;

    @NonNull
    private Double balance;

    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @NonNull
    @JoinColumn(name = "id_client")
    private Person person;


}
