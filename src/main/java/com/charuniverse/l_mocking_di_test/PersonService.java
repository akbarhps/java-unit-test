package com.charuniverse.l_mocking_di_test;

import java.util.UUID;

public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person get(String id) {
        Person person = personRepository.selectById(id);
        if (person == null) {
            throw new IllegalArgumentException("Person Not Found!");
        }
        return person;
    }

    public Person register(String name) {
        Person person = new Person(UUID.randomUUID().toString(), name);
        personRepository.insertPerson(person);
        return person;
    }
}