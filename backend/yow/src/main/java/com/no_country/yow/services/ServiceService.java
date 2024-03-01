package com.no_country.yow.services;

import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Service;
import com.no_country.yow.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService implements CRUDServices<Service, Long> {

    @Autowired
    private ServiceRepository repository;

    @Override
    public ResponseEntity<?> save(Service data) throws YOWException {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(data));
    }

    @Override
    public ResponseEntity<List<Service>> findAll() {
        List<Service> listService = repository.findAll();

        return ResponseEntity.ok().body(listService);
    }

    @Override
    public ResponseEntity<?> updateById(Service service, Long id) throws YOWException {
        Optional<Service> serviceOptional = repository.findById(id);
        if(serviceOptional.isPresent()){
            Service serviceUpdate = serviceOptional.get();
            serviceUpdate.setNameService(service.getNameService());
            serviceUpdate.setMovements(service.getMovements());
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(serviceUpdate));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> findById(Long id) throws YOWException {
        Optional<Service> serviceOptional = repository.findById(id);
        if(serviceOptional.isPresent())
            return ResponseEntity.ok(serviceOptional.get());
        return ResponseEntity.notFound().build();
    }
}
