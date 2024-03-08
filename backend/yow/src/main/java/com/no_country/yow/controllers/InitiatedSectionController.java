package com.no_country.yow.controllers;

import com.no_country.yow.dto.MovementDTO;
import com.no_country.yow.dto.TransferContact;
import com.no_country.yow.dto.TransferDTO;
import com.no_country.yow.dto.VirtualWalletDTO;
import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Contact;
import com.no_country.yow.models.Movement;
import com.no_country.yow.models.Person;
import com.no_country.yow.models.Services;
import com.no_country.yow.models.VirtualWallet;
import com.no_country.yow.services.ContactService;
import com.no_country.yow.services.MovementService;
import com.no_country.yow.services.PersonService;
import com.no_country.yow.services.ServiceService;
import javax.websocket.server.PathParam;
import com.no_country.yow.services.VirtualWalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
            List<MovementDTO> movements = (List<MovementDTO>) beanMovementService.findByIdClient(virtualWallet).getBody();

            VirtualWalletDTO user = new VirtualWalletDTO();

//        user.setId(data.getId());
//        user.setName(data.getName());
//        user.setLastName(data.getLastName());
            user.setBalance(virtualWallet.getBalance());
            user.setMovements(movements);

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


    /* --- Transferencias --- */
    // Añadir contacto a la virtual wallet para posteriormente poderle transferir
    // Se necesita el id del virtual wallet


    @PostMapping("/create-contact/{id}")
    public ResponseEntity<?> createContact(@RequestBody Contact contact, @PathVariable Long id) throws YOWException {
        // Busca la persona por number document
        Person person = personFindByNumberDocument(contact.getNumberIdentification());

        // Busca el Virtual Wallet por ID
        VirtualWallet virtualWallet = virtualWalletFindById(id);
        virtualWallet.addContact(contact); // Guarda el contacto dentro de Virtual Wallet
        return beanVirtualWallet.save(virtualWallet); // Persiste ambas entidades
    }

    @PostMapping("/transfer-contact/{idVirtualWallet}")
    public ResponseEntity<?> transferToContact(@RequestBody TransferContact transferContact, @PathVariable Long idVirtualWallet) {
        try {
            // Busca el Virtual Wallet por ID
            VirtualWallet virtualWallet = virtualWalletFindById(idVirtualWallet);

            List<Contact> contactList = virtualWallet.getContacts();
            for (Contact c : contactList) {
                if (c.getAlias().equals(transferContact.getAlias())) {
                    Person person = personFindByNumberDocument(c.getNumberIdentification());
                    List<VirtualWallet> virtualWalletList = beanVirtualWallet.listVirtualWallet();
                    for (VirtualWallet v : virtualWalletList) {
                        if (v.getPerson().getId().equals(person.getId())) {
                            v.setBalance(v.getBalance() + transferContact.getBalance());
                            virtualWallet.setBalance(virtualWallet.getBalance() - transferContact.getBalance());
                            beanVirtualWallet.save(v);
                            beanVirtualWallet.save(virtualWallet);
                            return beanVirtualWallet.transfer(transferContact.getBalance(),virtualWallet);
                        }
                    }
                }
            }
            return ResponseEntity.notFound().build();
        } catch (YOWException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/rechargeAccount/{numberDocument}")
    public ResponseEntity<?> rechargeAccount(@PathVariable("numberDocument") String numberDocument, @RequestParam("mount") Double mount) {

        Person person = (Person) beanPerson.findByNumberDocument(numberDocument).getBody();

        return beanVirtualWallet.recharge(person, mount);
    }

    @PostMapping("/transfer/{numberDocument}")
    public ResponseEntity<?> transfer(@RequestBody TransferDTO transferDTO, @PathVariable String numberDocument) throws YOWException {

        Person personReceptora = (Person) beanPerson.findByNumberDocument(transferDTO.getNumberDocument()).getBody();
        Person personTransfer = (Person) beanPerson.findByNumberDocument(numberDocument).getBody();

        return beanVirtualWallet.transfer(personReceptora, transferDTO.getMount(), personTransfer);
    }

    @PostMapping("/service-pay/{numberDocument}")
    public ResponseEntity<?> servicePay(@PathVariable("numberDocument") String numberDocument, @RequestParam("mount") Double mount) {

        Person person = (Person) beanPerson.findByNumberDocument(numberDocument).getBody();

        return beanVirtualWallet.servicePay(person, mount);
    }

    public VirtualWallet virtualWalletFindById(Long id) throws YOWException {
        // Busca el virtual wallet por id, si no existe lanza una excepcion
        VirtualWallet virtualWallet = new VirtualWallet();
        ResponseEntity<?> result = beanVirtualWallet.findById(id);
        return (VirtualWallet) result.getBody();
    }

    public Person personFindByNumberDocument(String numberDocument) {
        // Valida el contacto por numberDocument, si no existe lanza una excepcion
        ResponseEntity<?> response = beanPerson.findByNumberDocument(numberDocument);
        return (Person) response.getBody();
    }

}
