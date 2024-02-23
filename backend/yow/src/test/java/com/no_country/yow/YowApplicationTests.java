package com.no_country.yow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.no_country.yow.enums.Roles;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Person;
import com.no_country.yow.services.PersonService;

@SpringBootTest
class YowApplicationTests {

  @Test
  void contextLoads() throws YOWException {}

}
