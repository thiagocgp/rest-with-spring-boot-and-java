package com.thiagopereira.api.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.thiagopereira.api.dto.PersonDto;
import com.thiagopereira.api.model.Person;

@Mapper(componentModel="spring")
public interface PersonMapper {
	
	PersonDto personToPersonDto(Person person);
	
	@InheritInverseConfiguration
	Person personDtoToPerson(PersonDto personDto);
}
