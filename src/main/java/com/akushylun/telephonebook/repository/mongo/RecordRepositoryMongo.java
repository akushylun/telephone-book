package com.akushylun.telephonebook.repository.mongo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.akushylun.telephonebook.entities.Record;
import com.akushylun.telephonebook.repository.RecordRepository;

@Repository
@Qualifier("RecordRepositoryMongo")
public interface RecordRepositoryMongo extends RecordRepository, MongoRepository<Record, Integer> {

}
