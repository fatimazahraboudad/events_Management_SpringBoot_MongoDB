package com.example.evenementCrud.repositories;

import com.example.evenementCrud.entities.Invited;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitedRepository extends MongoRepository<Invited,String> {
}
