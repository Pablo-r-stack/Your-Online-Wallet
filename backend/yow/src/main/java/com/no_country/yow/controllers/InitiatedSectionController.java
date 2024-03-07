package com.no_country.yow.controllers;

import com.no_country.yow.dto.UserDTO;
import com.no_country.yow.dto.VirtualWalletDTO;
import com.no_country.yow.models.Movement;
import com.no_country.yow.models.Person;
import com.no_country.yow.models.Services;
import com.no_country.yow.models.VirtualWallet;
import com.no_country.yow.repositories.VirtualWalletRepository;
import com.no_country.yow.services.MovementService;
import com.no_country.yow.services.PersonService;
import com.no_country.yow.services.ServiceService;
import com.no_country.yow.services.VirtualWalletService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/initiated")
public class InitiatedSectionController {

    private PersonService beanPerson;
    private VirtualWalletService beanVirtualWallet;
    private MovementService beanMovementService;
    private ServiceService beanServiceService;

    public InitiatedSectionController(PersonService personService, VirtualWalletService virtualWalletService, MovementService movementService, ServiceService serviceService) {
        this.beanPerson = personService;
        this.beanVirtualWallet = virtualWalletService;
        this.beanMovementService = movementService;
        this.beanServiceService = serviceService;

    }

    @GetMapping("/dashboard")
    public ResponseEntity<?> dashboard() {

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Person data = (Person) beanPerson.findByNumberDocument(authentication.getName()).getBody();
            VirtualWallet virtualWallet = (VirtualWallet) beanVirtualWallet.findByIdClient(data).getBody();
            List<Movement> movements = (List<Movement>) beanMovementService.findByIdClient(virtualWallet).getBody();

            VirtualWalletDTO user = new VirtualWalletDTO();

//        user.setId(data.getId());
//        user.setName(data.getName());
//        user.setLastName(data.getLastName());
            user.setBalance(virtualWallet.getBalance());
            user.setMovements(movements);
            user.setServices((List<Services>) beanServiceService.findAll().getBody());

            return ResponseEntity.ok().body(user);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/update-user/{numberDocument}")
    public ResponseEntity<?> updateUser(@PathParam("numberDocument") String numberDocument) {
        return beanPerson.findByNumberDocument(numberDocument);

    }

    @PostMapping("/save-update")
    public ResponseEntity<?> saveUpdate(@RequestBody Person updatePerson) {
        return beanPerson.updatePerson(updatePerson);
    }
}
