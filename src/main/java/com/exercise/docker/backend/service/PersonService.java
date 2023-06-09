package com.exercise.docker.backend.service;

import com.exercise.docker.backend.models.PersonEntity;
import com.exercise.docker.backend.models.dto.request.PersonDTO;
import com.exercise.docker.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;


    public Optional<PersonEntity> findById(Long id) {

       return personRepository.findById(id);
    }

    public PersonEntity save(PersonDTO person) {

        PersonEntity personEntity = new PersonEntity(person);



        return personRepository.save(personEntity);
    }

    public PersonEntity saveOrUpdate(PersonEntity person) {
        return personRepository.save(person);
    }

    public void delete(Long id) {

        personRepository.deleteById(id);
    }
}
