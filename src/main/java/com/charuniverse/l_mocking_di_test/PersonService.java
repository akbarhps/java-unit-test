package com.charuniverse.l_mocking_di_test;

public class PersonService {

    private PersonRepository personRepository;

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
}