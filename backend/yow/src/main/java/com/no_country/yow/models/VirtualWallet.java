package com.no_country.yow.models;
import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_contact")
    private List<Contact> contacts;

    public VirtualWallet() {
        this.contacts = new ArrayList<>();
    }

    public VirtualWallet(String numberAccount, Double balance, Person person){
        this.numberAccount = numberAccount;
        this.balance = balance;
        this.person = person;
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
    }
}
