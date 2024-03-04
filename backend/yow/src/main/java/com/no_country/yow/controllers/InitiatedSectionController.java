package com.no_country.yow.controllers;


import com.no_country.yow.dto.VirtualWalletDTO;
import com.no_country.yow.models.Person;
import com.no_country.yow.services.PersonService;
import javax.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class InitiatedSectionController {

    private PersonService beanPerson;
    public InitiatedSectionController(PersonService personService){
        this.beanPerson  = personService;

    }



    @GetMapping("/section")
    public VirtualWalletDTO main(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        beanPerson.findByNumberDocument(authentication.getName());

        return  null;
    }
    
    
   @GetMapping("/update-user/{numberDocument}")
   public ResponseEntity<?> updateUser(@PathParam("numberDocument") String numberDocument){
       return beanPerson.findByNumberDocument(numberDocument);
       
   }
   
   @PostMapping("/save-update")
   public ResponseEntity<?> saveUpdate(@RequestBody Person updatePerson){
       
       return null;
       
   }
}
