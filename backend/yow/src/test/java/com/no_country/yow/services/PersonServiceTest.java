//package com.no_country.yow.services;
//
//import com.no_country.yow.controllers.HomeController;
//import com.no_country.yow.enums.Roles;
//import com.no_country.yow.exceptions.YOWException;
//import com.no_country.yow.models.Country;
//import com.no_country.yow.models.Person;
//import com.no_country.yow.repositories.PersonRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@Slf4j
//class PersonServiceTest {
//
//    PersonService personService;
//    PersonRepository personRepositoryMock;
//    HomeController homeController;
//
//    @BeforeEach
//    void setUp() {
//        personRepositoryMock = Mockito.mock(PersonRepository.class);
//        personService = new PersonService(personRepositoryMock);
//        homeController = new HomeController(personService);
//    }
//
//    @Test
//    void register() throws YOWException {
//        // Creación de objetos simulados
//        Country c = new Country();
//        c.setId(1L);
//        c.setCountry("Colombia");
//
//        Person p = new Person();
//        p.setId(1L);
//        p.setName("Juan");
//        p.setLastName("Pacheco");
//        p.setNumberIdentification("1002193737");
//        p.setEmail("jpachecoim044@gmail.com");
//        p.setPassword("Juan34241.");
//        p.setRol(Roles.Administrator);
//        p.setCountry(c);
//
//        // Configuración del comportamiento del repositorio mock
//        Mockito.when(personRepositoryMock.save(Mockito.any())).thenReturn(p);
//
//        // Ejecución del método a probar
//        ResponseEntity<?> result = homeController.register(p);
//
//        // Verificación del resultado
//        assertEquals(HttpStatus.CREATED, result.getStatusCode());
//    }
//
//    @Test
//    void changePassWord() throws YOWException {
//        // Creamos el país y la persona simulados
//        Country c = new Country();
//        c.setId(1L);
//        c.setCountry("Colombia");
//
//        Person p = new Person();
//        p.setId(1L);
//        p.setName("Juan");
//        p.setLastName("Pacheco");
//        p.setNumberIdentification("1002193737");
//        p.setEmail("jpachecoim044@gmail.com");
//        p.setPassword("Juan34241.");
//        p.setRol(Roles.Administrator);
//        p.setCountry(c);
//
//        // Definimos la nueva contraseña y el número de documento
//        String pass = "MockitoTest";
//        String numberDocument = "1002193737";
//
//        // Simulamos el comportamiento del método findByNumberDocument()
//        Mockito.when(personRepositoryMock.findByNumberDocument(numberDocument)).thenReturn(p);
//
//        // Simulamos el comportamiento del método updatePassword()
//        Mockito.doNothing().when(personRepositoryMock).updatePassword(numberDocument, pass);
//
//        // Ejecutamos el método a probar
//        ResponseEntity<?> result2 = homeController.changePassword(numberDocument, pass);
//
//        log.info("Objeto " + result2.toString());
//
//        // Verificamos si la contraseña se actualizó correctamente
//        assertEquals(HttpStatus.OK, result2.getStatusCode());
//        assertEquals("Contraseña Actualizada Exitosamente", result2.getBody());
//}
//}