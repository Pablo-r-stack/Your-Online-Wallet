package com.no_country.yow.security.uservalid;

import com.no_country.yow.dto.UserDTO;
import com.no_country.yow.exceptions.CallExceptionYOW;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Person;
import com.no_country.yow.repositories.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;


@Slf4j
@Service
public class UserValid implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    private final CallExceptionYOW valid = new CallExceptionYOW(); // Instancia de una clase que maneja excepciones específicas

    @Override
    public UserDetails loadUserByUsername(String userDocument) {
        try {
            Person optPerson = personRepository.findByNumberDocument(userDocument);
            valid.isUserExist(optPerson);

            return new User(
                    optPerson.getNumberIdentification(),
                    optPerson.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_".concat(String.valueOf(optPerson.getRol())))));

        } catch (YOWException e) {
           // throw new RuntimeException(e.getMessage().concat(" ").concat(userDocument));
           log.info("Error: " + e.getMessage() + " " + userDocument);
           
                    return new User(
                    "",
                    "",
                    true,
                    true,
                    true,
                    true,
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_".concat(String.valueOf("")))));

        }
    }
}
