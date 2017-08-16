package com.akushylun.telephonebook.repository.hibernate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akushylun.telephonebook.entities.Record;
import com.akushylun.telephonebook.repository.RecordRepository;

@Repository
@Qualifier("RecordRepositoryHibernate")
public interface RecordRepositoryHibernate extends RecordRepository, JpaRepository<Record, Integer> {


}
