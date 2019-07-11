package com.ibm.treinamento;

import static com.ibm.treinamento.VendaRoute.DIRECT_VENDA_ROUTE_ORQUESTRACAO;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component
public class VendaController extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		rest("/v1/")
			 .description("venda REST service")
			 .id("venda-rest")
        	 .get("venda")
        	 	.description("buscar a venda")
        	 		.to(DIRECT_VENDA_ROUTE_ORQUESTRACAO);
		
	}

}
