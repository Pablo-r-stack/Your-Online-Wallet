package com.no_country.yow.dto;

import com.no_country.yow.models.Movement;
import com.no_country.yow.models.Services;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class VirtualWalletDTO implements Serializable {

//    private Long id;
//    private String name;
//    private String lastName;
    private Double balance;
    private List<MovementDTO> movements;

    public VirtualWalletDTO() {
        this.movements = new ArrayList<>();
    }
}
