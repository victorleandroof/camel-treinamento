package com.ibm.treinamento;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ServerInterneErro implements Processor {
	
	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, HttpStatus.INTERNAL_SERVER_ERROR);
		exchange.getOut().setBody(exchange.getProperty(Exchange.EXCEPTION_CAUGHT).toString());
		
	}
	
	
	
}
