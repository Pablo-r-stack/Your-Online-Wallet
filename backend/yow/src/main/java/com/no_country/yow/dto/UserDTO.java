package com.no_country.yow.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Long id;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String name;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String lastname;
    private String username;
    private String password;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String rol;

}
