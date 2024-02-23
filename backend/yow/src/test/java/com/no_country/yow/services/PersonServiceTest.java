package com.no_country.yow.services;

import com.no_country.yow.controllers.HomeController;
import com.no_country.yow.enums.Roles;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Countries;
import com.no_country.yow.models.Person;
import com.no_country.yow.repositories.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
class PersonServiceTest {

  PersonService personService;
    PersonRepository personRepositoryMock;
    HomeController homeController;

    @BeforeEach
    void setUp() {
        personRepositoryMock = Mockito.mock(PersonRepository.class);
        personService = new PersonService(personRepositoryMock);
        homeController = new HomeController(personService);
    }

    @Test
    void save() throws YOWException {

        Countries c = new Countries();
        c.setId(1L);
        c.setCountry("Colombia");

        Person p = new Person();
        p.setId(1L);
        p.setName("Juan");
        p.setLastName("Pacheco");
        p.setNumberIdentification(1002193737L);
        p.setEmail("jpachecoim044@gmail.com");
        p.setPassword("Juan34241.");
        p.setRol(Roles.Administrator);
        p.setCountry(c);

        Mockito.when(personRepositoryMock.save(Mockito.any())).thenReturn(p);

        ResponseEntity<?> result = homeController.register(p);

        log.info("Objecto: " + result.toString());

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }
}