package io.tbc.spring.ws.service;

import org.springframework.stereotype.Service;

import io.tbc.spring.ws.wsdlClasses.AdditionInput;
import io.tbc.spring.ws.wsdlClasses.Output;

@Service
public class CalculatorService {
	
	public Output addition(AdditionInput input) {
		Output output = new Output();
        output.setResult(input.getNumber1() + input.getNumber2());
        return output;
	}

}
