package com.no_country.yow.services;

import com.no_country.yow.models.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    List<Account> findAll();
    Optional<Account> findById(String id);
    Optional<Account> save(Account account);
    void delete(Account account);
}
