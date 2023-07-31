package com.filrouge.filrouge.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filrouge.filrouge.Model.Client;
import com.filrouge.filrouge.Repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Integer id) {
        return clientRepository.findById(id);
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Boolean modifyClient(Client client, Integer id) {
        Optional<Client> clientToModify = clientRepository.findById(id);
        if (clientToModify.isPresent()) {
             clientRepository.save(client);
             return true;
        }
        return false;
    }

    public boolean deleteClientById(Integer id) {
        Optional<Client> clientToDelete = clientRepository.findById(id);
        if (clientToDelete.isPresent()) {
            clientRepository.deleteById(id);
            return true;

        }
        return false;

    }
}
