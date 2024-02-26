package com.no_country.yow.services;

import com.no_country.yow.models.Bank;

import java.util.List;
import java.util.Optional;

public interface IBankService {
    List<Bank> findAll();
    Optional<Bank> findById(Long id);
    Optional<Bank> save(Bank bank);
    void delete(Bank bank);
}
