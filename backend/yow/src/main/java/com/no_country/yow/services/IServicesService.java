package com.no_country.yow.services;

import com.no_country.yow.models.Services;

import java.util.List;
import java.util.Optional;

public interface IServicesService {
    List<Services> findAll();
    Optional<Services> findById(Long id);
    Optional<Services> save(Services services);
    void delete(Services services);
}
