package com.no_country.yow.controllers;


import com.no_country.yow.dto.AccountDTO;
import com.no_country.yow.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("section")
public class InitiatedSectionController {

    private PersonService beanPerson;
    public InitiatedSectionController(PersonService personService){
        this.beanPerson  = personService;

    }



    @GetMapping("main")
    public AccountDTO main(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        beanPerson.findByNumberDocument(authentication.getName());

        return  null;
    }
}
