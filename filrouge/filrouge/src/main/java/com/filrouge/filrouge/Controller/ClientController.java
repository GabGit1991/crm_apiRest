package com.filrouge.filrouge.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.filrouge.filrouge.Model.Client;
import com.filrouge.filrouge.Service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    @ResponseBody
    public ResponseEntity<String>  getAllClients() {
        List<Client> listClients = clientService.getAllClient();
        return ResponseEntity.ok().body(listClients.toString());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Client> getClientById(@PathVariable Integer id) {
        Optional<Client> optionalClient = clientService.getClientById(id);
        if (optionalClient.isPresent()) {
            Client clientFound = optionalClient.get();
            return ResponseEntity.ok().body(clientFound);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Client> addClients(@RequestBody Client client) {
        Client clientAdded = clientService.addClient(client);
        return ResponseEntity.ok().body(clientAdded);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String>  deleteClient(@PathVariable("id") Integer id) {

        Boolean hasBeenDeleted = clientService.deleteClientById(id);
        if (hasBeenDeleted) {
            return ResponseEntity.ok().body("Votre cilent a bien été supprimé");
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<String>  modifierClient(@PathVariable("id") Integer id, @RequestBody Client client) {
        Boolean hasBeenModified = clientService.modifyClient(client, id);
        if (hasBeenModified) {
            return ResponseEntity.ok().body("Votre client a bien été modifié en : " + client.toString());
        }
        return ResponseEntity.notFound().build();
    }

}
