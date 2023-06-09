package com.exercise.docker.backend.models.dto.request;

import lombok.Data;

@Data
public class PersonDTO {

    private String name;
    private String lastName;
    private Byte age;
}
