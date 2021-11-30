package io.tbc.spring.ws.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.tbc.spring.ws.service.CalculatorService;
import io.tbc.spring.ws.wsdlClasses.AdditionInput;
import io.tbc.spring.ws.wsdlClasses.Output;


@Endpoint
public class Calculator {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CalculatorService service;
	
    @ResponsePayload
    @PayloadRoot(namespace = "http://medium.com/types/calculator", localPart = "AdditionInput")
    public Output addition(@RequestPayload AdditionInput input){
        logger.info("Request received for addition with input "+input);
        Output output=service.addition(input);
        System.out.println("Client output="+output.getResult());
        return output;
    }

}
