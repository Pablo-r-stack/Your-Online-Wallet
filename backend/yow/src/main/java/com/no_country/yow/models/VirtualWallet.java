package com.no_country.yow.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Data
public class VirtualWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numberAccount;

    @NonNull
    private Double balance;

    @OneToOne
    @NonNull
    @JoinColumn(name = "id_client")
    private Person person;
        
    @Transient
    private static  final AtomicLong count = new AtomicLong();

    @PrePersist
    public  void createNumbercount(){
        this.numberAccount  = String.format(("%010d"), count.incrementAndGet());
    }

}
