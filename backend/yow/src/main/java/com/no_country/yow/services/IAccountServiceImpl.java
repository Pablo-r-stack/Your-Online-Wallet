package com.no_country.yow.services;

import com.no_country.yow.models.Account;
import com.no_country.yow.models.AccountMovements;
import com.no_country.yow.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IAccountServiceImpl implements IAccountService{

    @Autowired
    private AccountRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<AccountMovements> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Account> findById(String id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Account> save(Account account) {
        return Optional.of(repository.save(account));
    }

    @Override
    @Transactional
    public void delete(Account account) {
        repository.delete(account);
    }
}
