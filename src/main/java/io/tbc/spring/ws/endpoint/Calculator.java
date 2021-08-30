package io.tbc.spring.ws.endpoint;

import com.medium.types.calculator.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class Calculator {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

    @ResponsePayload
    @PayloadRoot(namespace = "http://medium.com/types/calculator", localPart = "AdditionInput")
    public Output addition(@RequestPayload AdditionInput input){
        logger.info("Request received for addition with input "+input);
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() + input.getNumber2());
        return output;
    }

}
