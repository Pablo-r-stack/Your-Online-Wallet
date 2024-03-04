/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.no_country.yow.repositories;

import com.no_country.yow.dto.UserDTO;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpach
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

    @Query("SELECT p FROM Person p WHERE p.numberIdentification = ?1")
    public Person findByNumberDocument(String numdocument) throws YOWException;

    @Query("SELECT p FROM Person p WHERE p.numberIdentification = ?1")
    public Person data(String number);

    @Modifying
    @Query("UPDATE Person p SET p.password = ?2  WHERE p.numberIdentification = ?1")
    public void updatePassword(String numberDocument,String newPassword) throws YOWException;
    
}
