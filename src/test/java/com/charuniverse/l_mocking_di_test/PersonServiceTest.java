package com.charuniverse.l_mocking_di_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> personService.get("none"));
    }

    @Test
    void testGetPersonSuccess() {
        String personId = "akbar";
        String personName = "Akbar ganteng";

        when(personRepository.selectById(personId)).thenReturn(
                new Person(personId, personName)
        );

        Person person = personService.get(personId);

        Assertions.assertNotNull(person);
        Assertions.assertEquals(personId, person.getId());
        Assertions.assertEquals(personName, person.getName());
    }

    @Test
    void testRegisterPerson() {
        String name = "Akbar ganteng";

        Person person = personService.register(name);
        Assertions.assertNotNull(person);
        Assertions.assertNotNull(person.getId());
        Assertions.assertEquals(name, person.getName());

        // Check if personRepository.insertPerson(person) is called once when test run
        verify(personRepository, times(1)).insertPerson(person);
    }
}