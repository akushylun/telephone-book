package com.akushylun.telephonebook.repository.mongo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.akushylun.telephonebook.entities.Person;
import com.akushylun.telephonebook.repository.PersonRepository;

@Repository
@Qualifier("PersonRepositoryMongo")
public interface PersonRepositoryMongo extends PersonRepository, MongoRepository<Person, Integer> {

}
