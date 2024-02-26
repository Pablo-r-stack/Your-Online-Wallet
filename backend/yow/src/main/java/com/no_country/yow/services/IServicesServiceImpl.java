package com.no_country.yow.services;

import com.no_country.yow.models.Services;
import com.no_country.yow.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IServicesServiceImpl implements IServicesService{

    @Autowired
    private ServicesRepository repository;

    @Override
    public List<Services> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Services> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Services> save(Services services) {
        return Optional.of(repository.save(services));
    }

    @Override
    public void delete(Services services) {
        repository.delete(services);
    }
}
