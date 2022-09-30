package com.thiagopereira.api.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thiagopereira.api.exceptions.UnsupportedMathOperationException;
import com.thiagopereira.api.util.Numbers;

@RestController
public class MathController {

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if(!Numbers.isNumeric(numberOne) || !Numbers.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Pleae set a numeric value!");
		}

		return Numbers.convertToDouble(numberOne) + Numbers.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!Numbers.isNumeric(numberOne) || !Numbers.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Pleae set a numeric value!");
		}
		
		return Numbers.convertToDouble(numberOne) - Numbers.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!Numbers.isNumeric(numberOne) || !Numbers.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Pleae set a numeric value!");
		}
		
		return Numbers.convertToDouble(numberOne) * Numbers.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!Numbers.isNumeric(numberOne) || !Numbers.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		if(Numbers.convertToDouble(numberTwo) == 0D) {
			throw new UnsupportedMathOperationException("Cannot divide by zero!");
		}
		
		return Numbers.convertToDouble(numberOne) / Numbers.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value="/squareRoot/{numberOne}", method=RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value = "numberOne") String numberOne) throws Exception {
		
		if(!Numbers.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return Math.sqrt(Numbers.convertToDouble(numberOne));
	}
	
	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!Numbers.isNumeric(numberOne) || !Numbers.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return (Numbers.convertToDouble(numberOne) + Numbers.convertToDouble(numberTwo)) / 2;
	}	
}
