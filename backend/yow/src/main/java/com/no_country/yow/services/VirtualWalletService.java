package com.no_country.yow.services;

import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.VirtualWallet;
import com.no_country.yow.repositories.VirtualWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VirtualWalletService implements CRUDServices<VirtualWallet, String> {

    @Autowired
    private VirtualWalletRepository repository;

    @Override
    public ResponseEntity<?> save(VirtualWallet data) throws YOWException {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(data));
    }

    @Override
    public List<VirtualWallet> findAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<?> updateById(VirtualWallet virtualWallet, String id) throws YOWException {
        Optional<VirtualWallet> virtualWalletOptional = repository.findById(id);
        if(virtualWalletOptional.isPresent()){
            VirtualWallet virtualWalletDb = virtualWalletOptional.get();
            virtualWalletDb.setBalance(virtualWallet.getBalance());
            virtualWalletDb.setServices(virtualWallet.getServices());
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(virtualWalletDb));
        }
        return ResponseEntity.notFound().build();
    }


    @Override
    public ResponseEntity<?> findById(String id) throws YOWException {
        Optional<VirtualWallet> virtualWalletOptional = repository.findById(id);
        if(virtualWalletOptional.isPresent())
            return ResponseEntity.ok(virtualWalletOptional.get());
        return ResponseEntity.notFound().build();
    }
}
