package com.no_country.yow.services;

import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Contact;
import com.no_country.yow.repositories.ContacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService implements CRUDServices<Contact, Long> {

    @Autowired
    private ContacRepository repository;

    @Transactional
    @Override
    public ResponseEntity<?> save(Contact data) throws YOWException {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(data));
    }

    @Override
    public ResponseEntity<List<Contact>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Override
    public ResponseEntity<?> updateById(Contact contact, Long id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResponseEntity<?> findById(Long id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
