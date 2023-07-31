package com.filrouge.filrouge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filrouge.filrouge.Model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    
}
