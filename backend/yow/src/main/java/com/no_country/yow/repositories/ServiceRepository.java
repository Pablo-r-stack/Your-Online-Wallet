/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.no_country.yow.repositories;

import com.no_country.yow.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpach
 */
@Repository
public interface ServiceRepository extends JpaRepository<Services, Long>{
    
    @Query("SELECT s FROM Services s WHERE s.service = ?1")
    public Services findByName(String name);
    
}
