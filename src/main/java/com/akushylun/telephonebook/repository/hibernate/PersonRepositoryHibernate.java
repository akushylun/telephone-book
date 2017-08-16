package com.akushylun.telephonebook.repository.hibernate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akushylun.telephonebook.entities.Person;
import com.akushylun.telephonebook.repository.PersonRepository;

@Repository
@Qualifier("PersonRepositoryHibernate")
public interface PersonRepositoryHibernate extends PersonRepository, JpaRepository<Person, Integer> {



}
