package com.exercise.docker.backend.repository;

import com.exercise.docker.backend.models.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
