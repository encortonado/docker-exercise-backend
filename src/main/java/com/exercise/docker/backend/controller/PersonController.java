package com.exercise.docker.backend.controller;

import com.exercise.docker.backend.models.PersonEntity;
import com.exercise.docker.backend.models.dto.request.PersonDTO;
import com.exercise.docker.backend.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("v1/person")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class.getName());


    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PersonEntity>>  findOne (@PathVariable Long id) {
        LOGGER.info("[DockerBackend - findOne] Buscando uma pessoa com o id: " + id);


        return ResponseEntity.ok(personService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PersonEntity> savePerson (@RequestBody PersonDTO person) {

        PersonEntity personPost = personService.save(person);

        LOGGER.info("[DockerBackend - findOne] Salvando pessoa : " + personPost);


        return ResponseEntity.created(
                URI.create(String.format("/person/%s", personPost.getId()))).body(personPost);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonEntity> updatePerson (
            @PathVariable Long id, @RequestBody PersonDTO person) {

        Optional<PersonEntity> personFound = personService.findById(id);

        if (personFound.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PersonEntity personEntity = personFound.get();

        personEntity.setName(person.getName() == null ? personEntity.getName() : person.getName());
        personEntity.setLastName(person.getLastName() == null ? personEntity.getLastName() : person.getLastName());
        personEntity.setAge(person.getAge() == null ? personEntity.getAge() : person.getAge());



        return ResponseEntity.ok(personService.saveOrUpdate(personEntity));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {

        personService.delete(id);

        return ResponseEntity.ok().body("Solicitação enviada, veja pelo endpoint de busca depois.");
    }

}
