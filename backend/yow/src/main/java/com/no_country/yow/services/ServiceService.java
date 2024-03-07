package com.no_country.yow.services;

import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Services;
import com.no_country.yow.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements CRUDServices<Services, Long> {

    @Autowired
    private ServiceRepository repository;
    
    
    @Override
    public ResponseEntity<List<Services>> findAll() {
        List<Services> listService = repository.findAll();

        return ResponseEntity.ok().body(listService);
    }
    
    public Services findByName(String name){
        
        try {
            Services id = repository.findByName(name);
            
            if(id == null){
                throw new Exception("El Servicio solicitado no se encuentra diponible");
            }
            return id;
        } catch (Exception e) {
            
            return null;
        }
        
    }

    
    
//    @Override
//    public ResponseEntity<?> save(Services data) throws YOWException {
//        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(data));
//    }


//    @Override
//    public ResponseEntity<?> updateById(Services service, Long id) throws YOWException {
//        Optional<Services> serviceOptional = repository.findById(id);
//        if(serviceOptional.isPresent()){
//            Services serviceUpdate = serviceOptional.get();
//            serviceUpdate.setNameService(service.getNameService());
//            serviceUpdate.setMovements(service.getMovements());
//            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(serviceUpdate));
//        }
//        return ResponseEntity.notFound().build();
//    }

//    @Override
//    public ResponseEntity<?> findById(Long id) throws YOWException {
//        Optional<Services> serviceOptional = repository.findById(id);
//        if(serviceOptional.isPresent())
//            return ResponseEntity.ok(serviceOptional.get());
//        return ResponseEntity.notFound().build();
//    }

    @Override
    public ResponseEntity<?> updateById(Services t, Long id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ResponseEntity<?> save(Services data) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResponseEntity<?> findById(Long id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
}
}
