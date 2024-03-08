package com.no_country.yow.repositories;

import com.no_country.yow.models.Person;
import com.no_country.yow.models.VirtualWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

public interface VirtualWalletRepository extends JpaRepository<VirtualWallet, Long> {
    
    @Query("SELECT MAX(v.numberAccount) FROM VirtualWallet v")
    public String numberAccount();
    
    @Query("SELECT vw FROM VirtualWallet vw WHERE vw.person = ?1")
    public VirtualWallet virtualWalletByIdClient(Person person);
    
    
    @Modifying
    @Query("UPDATE VirtualWallet vw SET vw.balance = ?2 WHERE vw.person = ?1")
    public void recharge(Person person, Double mount);

    @Modifying
    @Query("UPDATE VirtualWallet vw SET vw.balance = ?2 WHERE vw.person = ?1")
    public void transfer(Person person, Double mount);
}