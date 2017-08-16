package com.akushylun.telephonebook.repository;

import com.akushylun.telephonebook.entities.Person;

public interface PersonRepository {

    Person findByUsername(String username);

    void save(Person person);
}
