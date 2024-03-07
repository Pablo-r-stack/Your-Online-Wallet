package com.no_country.yow.services;

import com.no_country.yow.dto.MovementDTO;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Movement;
import com.no_country.yow.models.VirtualWallet;
import com.no_country.yow.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovementService implements CRUDServices<Movement, Long> {

    @Autowired
    private MovementRepository repository;

    @Override
    public ResponseEntity<?> save(Movement data) throws YOWException {
        try {
            
        repository.save(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(data));
        } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: al guardar el registro del movimiento");
        }
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
    
    //Los movimientos pueden estar vacios por tal motivo no es necesario colocar excepcion de un posible null
        public ResponseEntity<?> findByIdClient(VirtualWallet virtualWallet) {
            try {
            List<MovementDTO> movement = repository.movementByClient(virtualWallet);

            return ResponseEntity.ok().body(movement);
                
            } catch (Exception e) {
                log.info("Error: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }


    }
}
