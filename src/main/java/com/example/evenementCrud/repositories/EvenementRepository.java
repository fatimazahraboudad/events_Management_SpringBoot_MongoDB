package com.example.evenementCrud.repositories;

import com.example.evenementCrud.entities.Evenement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends MongoRepository<Evenement,String> {
}
