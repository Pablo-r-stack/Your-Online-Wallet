package com.no_country.yow.services;

import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Country;
import com.no_country.yow.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService implements CRUDServices<Country, Long> {

    @Autowired
    private CountryRepository repository;

//    @Override
//    public ResponseEntity<?> save(Country data) throws YOWException {
//        return ResponseEntity.internalServerError().build();
//    }

    @Override
    public ResponseEntity<List<Country>> findAll() {

        List<Country> listCountries = repository.findAll();

        return ResponseEntity.ok().body(listCountries);
    }

//    @Override
//    public ResponseEntity<?> updateById(Country country, Long id) throws YOWException {
//        return ResponseEntity.internalServerError().build();
//    }
//
//    @Override
//    public ResponseEntity<?> findById(Long id) throws YOWException {
//        Optional<Country> countryOptional = repository.findById(id);
//        if(countryOptional.isPresent())
//            return ResponseEntity.ok().body(countryOptional.get());
//        return ResponseEntity.notFound().build();
//    }

    @Override
    public ResponseEntity<?> save(Country data) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResponseEntity<?> updateById(Country t, Long id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResponseEntity<?> findById(Long id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
