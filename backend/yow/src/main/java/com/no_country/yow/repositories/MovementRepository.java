package com.no_country.yow.repositories;

import com.no_country.yow.dto.MovementDTO;
import com.no_country.yow.models.Movement;
import com.no_country.yow.models.VirtualWallet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovementRepository extends JpaRepository<Movement, Long> {
    
    @Query("SELECT new com.no_country.yow.dto.MovementDTO(m.services, m.date, m.mount, m.successful) FROM Movement m WHERE m.wallet = ?1")
    public List<MovementDTO> movementByClient(VirtualWallet virtualWallet);
}
