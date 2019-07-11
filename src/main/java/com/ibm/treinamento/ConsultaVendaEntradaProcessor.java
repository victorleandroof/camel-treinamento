package com.ibm.treinamento;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.http4.HttpMethods;
import org.springframework.stereotype.Component;

@Component
public class ConsultaVendaEntradaProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getOut().setHeader(Exchange.HTTP_METHOD, HttpMethods.GET);
		exchange.getOut().setHeader("codvenda", exchange.getIn().getHeader("codvenda"));
		exchange.getOut().setBody("");
	}

}
