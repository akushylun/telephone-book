package com.akushylun.telephonebook.repository;

import java.util.List;

import com.akushylun.telephonebook.entities.Record;

public interface RecordRepository {

    List<Record> findByPersonId(int id);

    void delete(int id);

    void save(Record record);
}
