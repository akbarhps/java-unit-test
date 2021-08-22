package com.charuniverse.l_mocking_di_test;

public interface PersonRepository {
    Person selectById(String id);

    void insertPerson(Person person);
}