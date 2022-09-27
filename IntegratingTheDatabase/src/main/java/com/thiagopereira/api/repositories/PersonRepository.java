package com.thiagopereira.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiagopereira.api.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
