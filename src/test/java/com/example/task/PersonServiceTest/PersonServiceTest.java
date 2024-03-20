
package com.example.task.PersonServiceTest;

import com.example.task.entity.PersonEntity;
import com.example.task.repository.PersonRepository;
import com.example.task.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void testSaveMessage() throws JsonProcessingException {
        String jsonMessage = "{\"firstName\":\"G\",\"lastName\":\"Ka\"}";
        personService.saveMessage(jsonMessage);

        List<PersonEntity> persons = personRepository.findAll();
        assertFalse(persons.isEmpty());
        assertEquals("G", persons.get(0).getFirstName());
        assertEquals("Ka", persons.get(0).getLastName());
    }
}

