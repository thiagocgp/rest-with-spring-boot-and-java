package com.thiagopereira.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.thiagopereira.api.controllers.PersonController;
import com.thiagopereira.api.dto.PersonDto;
import com.thiagopereira.api.exceptions.ResourceNotFoundException;
import com.thiagopereira.api.mapper.PersonMapper;
import com.thiagopereira.api.model.Person;
import com.thiagopereira.api.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper personMapper;
	
	public PersonDto findById(Long id) {		
		logger.info("Finding one person!");
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		PersonDto personDto = personMapper.personToPersonDto(entity);
		personDto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("list_persons"));
		return personDto;
	}
	
	public List<PersonDto> findAll() {
		logger.info("Finding all people!");
		List<Person> entities = repository.findAll();
		List<PersonDto> personsDto = new ArrayList<>();
		for (Person entity : entities) {
			PersonDto personDto = personMapper.personToPersonDto(entity);
			personDto.add(linkTo(methodOn(PersonController.class).findById(personDto.getId())).withSelfRel());
			personsDto.add(personDto);
		}
		return personsDto;
	}
	
	public PersonDto create(PersonDto personDto) {
		logger.info("Creating one person!");
		Person entity = personMapper.personDtoToPerson(personDto);
		entity = repository.save(entity);
		personDto = personMapper.personToPersonDto(entity);
		personDto.add(linkTo(methodOn(PersonController.class).findById(personDto.getId())).withSelfRel());
		return personDto;
	}
	
	public PersonDto update(PersonDto personDto) {
		logger.info("Updating one person!");
		Person entity = repository.findById(personDto.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		entity.setFirstName(personDto.getFirstName());
		entity.setLastName(personDto.getLastName());
		entity.setAddress(personDto.getAddress());
		entity.setGender(personDto.getGender());
		entity = repository.save(entity);
		personDto = personMapper.personToPersonDto(entity);
		personDto.add(linkTo(methodOn(PersonController.class).findById(personDto.getId())).withSelfRel());
		return personDto;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
}
