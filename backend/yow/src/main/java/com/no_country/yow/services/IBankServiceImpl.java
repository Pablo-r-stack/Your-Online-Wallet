package com.no_country.yow.services;

import com.no_country.yow.models.Bank;
import com.no_country.yow.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IBankServiceImpl implements IBankService{

    @Autowired
    private BankRepository repository;

    @Override
    public List<Bank> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Bank> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Bank> save(Bank bank) {
        return Optional.of(repository.save(bank));
    }

    @Override
    public void delete(Bank bank) {
        repository.delete(bank);
    }
}
