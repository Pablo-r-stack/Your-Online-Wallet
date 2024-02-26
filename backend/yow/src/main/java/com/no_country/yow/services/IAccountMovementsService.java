package com.no_country.yow.services;

import com.no_country.yow.models.AccountMovements;

import java.util.List;
import java.util.Optional;

public interface IAccountMovementsService{
    List<AccountMovements> findAll();
    Optional<AccountMovements> findById(Long id);
    Optional<AccountMovements> save(AccountMovements accountMovements);
    void delete(AccountMovements accountMovements);
}
