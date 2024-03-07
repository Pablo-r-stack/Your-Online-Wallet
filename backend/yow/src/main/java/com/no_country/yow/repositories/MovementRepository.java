package com.no_country.yow.repositories;

import com.no_country.yow.models.Movement;
import com.no_country.yow.models.VirtualWallet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovementRepository extends JpaRepository<Movement, Long> {
    
    @Query("SELECT m FROM Movement m WHERE m.wallet = ?1")
    public List<Movement> movementByClient(VirtualWallet virtualWallet);
}
