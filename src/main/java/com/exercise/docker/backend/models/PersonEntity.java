package com.exercise.docker.backend.models;

import com.exercise.docker.backend.models.dto.request.PersonDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class PersonEntity {


    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String lastName;

    private Byte age;


    public PersonEntity(PersonDTO personDTO) {
        this.name = personDTO.getName();
        this.lastName = personDTO.getLastName();
        this.age = personDTO.getAge();
    }
}
