package com.no_country.yow.services;

import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Movement;
import com.no_country.yow.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementService implements CRUDServices<Movement, Long> {

    @Autowired
    private MovementRepository repository;

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<?> save(Movement data) throws YOWException {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(data));
    }

    @Override
    public ResponseEntity<List<Movement>> findAll() {

        List<Movement> listMovements = repository.findAll();
        return ResponseEntity.ok().body(listMovements);
    }

//    @Override
//    public ResponseEntity<?> updateById(Movement movement, Long id) throws YOWException {
//        Optional<Movement> movementOptional = repository.findById(id);
//        if(movementOptional.isPresent()){
//            Movement movementUpdate = movementOptional.get();
//            movementUpdate.setDate(movement.getDate());
//            movementUpdate.setMount(movement.getMount());
//            movementUpdate.setReference(movement.getReference());
//            movementUpdate.setSuccessful(movement.getSuccessful());
//            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(movementUpdate));
//        }
//        return ResponseEntity.notFound().build();
//    }

//    @Override
//    public ResponseEntity<?> findById(Long id) throws YOWException {
//        Optional<Movement> movementOptional = repository.findById(id);
//        if(movementOptional.isPresent())
//            return ResponseEntity.ok(movementOptional.get());
//        return ResponseEntity.notFound().build();
//    }

//    @Override
//    public ResponseEntity<?> updateById(Movement t, Long id) throws YOWException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public ResponseEntity<?> updateById(Movement t, Long id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResponseEntity<?> findById(Long id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
