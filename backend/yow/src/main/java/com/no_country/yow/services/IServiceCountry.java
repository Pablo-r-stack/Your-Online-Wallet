package com.no_country.yow.services;

import com.no_country.yow.models.Countries;

import java.util.List;
import java.util.Optional;

public interface IServiceCountry {
    List<Countries> findAll();
    Optional<Countries> findById(Long id);
}
