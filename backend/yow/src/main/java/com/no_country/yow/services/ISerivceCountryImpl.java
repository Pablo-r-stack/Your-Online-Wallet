package com.no_country.yow.services;

import com.no_country.yow.models.Countries;
import com.no_country.yow.repositories.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISerivceCountryImpl implements IServiceCountry{

    @Autowired
    private CountriesRepository repository;
    @Override
    public List<Countries> findAll() {
        return repository.findAll();
    }
}
