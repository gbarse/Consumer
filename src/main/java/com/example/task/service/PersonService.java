package com.example.task.service;

import com.example.task.entity.PersonEntity;
import com.example.task.repository.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, ObjectMapper objectMapper) {
        this.personRepository = personRepository;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "sampleTopicName", groupId = "the-consumer-group")
    public void saveMessage (String message) throws JsonProcessingException {
        log.info("starting save message method");
        PersonEntity entity = objectMapper.readValue(message, PersonEntity.class);
        personRepository.save(entity);
        log.info("save message method finished");
    }
}
