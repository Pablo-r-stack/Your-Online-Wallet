package com.no_country.yow.services;

import com.no_country.yow.models.Account;
import com.no_country.yow.models.AccountMovements;
import com.no_country.yow.repositories.AccountMovementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IAccountMovementsServiceImpl implements IAccountMovementsService{

    @Autowired
    private AccountMovementsRepository repository;

    @Override
    public List<AccountMovements> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AccountMovements> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<AccountMovements> save(AccountMovements accountMovements) {
        return Optional.of(repository.save(accountMovements));
    }

    @Override
    public void delete(AccountMovements accountMovements) {
        repository.delete(accountMovements);
    }
}
