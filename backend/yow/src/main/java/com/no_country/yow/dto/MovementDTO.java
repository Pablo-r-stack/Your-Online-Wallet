/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.no_country.yow.dto;

import com.no_country.yow.models.Services;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author jpach
 */
@Data
@AllArgsConstructor
public class MovementDTO {
    private Services id;
    private Date date;
    private Double mount;
    private Boolean successful;
    
    
}
