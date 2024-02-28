package com.no_country.yow.repositories;

import com.no_country.yow.models.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {
}
