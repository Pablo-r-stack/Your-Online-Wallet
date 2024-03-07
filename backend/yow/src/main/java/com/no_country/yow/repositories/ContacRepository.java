package com.no_country.yow.repositories;

import com.no_country.yow.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContacRepository extends JpaRepository<Contact, Long> {
}
