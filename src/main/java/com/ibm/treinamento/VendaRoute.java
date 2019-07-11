package com.ibm.treinamento;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendaRoute  extends RouteBuilder{
	
	public static String DIRECT_VENDA_ROUTE = "direct:venda";
	public static String ID_VENDA_ROUTE = "venda-route";
	public static String DIRECT_VENDA_ROUTE_ORQUESTRACAO = "direct:venda-route-orquestracao";
	public static String ID_VENDA_ROUTE_ORQUESTRACOA = "venda-route-orquestracao";
	public static String VENDA_ROUTE_API = "https4://"+"treinamento-venda-app.herokuapp.com/venda"+"?bridgeEndpoint=false";
	private ConsultaVendaEntradaProcessor consultaVendaEntradaProcessor;
	private ConsultaVendaSaidaProcessor consultaVendaSaidaProcessor;
	private BadRequestProcessor badRequestProcessor;
	private ServerInterneErro serverInterneErro;
	
	@Autowired
	public VendaRoute(BadRequestProcessor badRequestProcessor,
			ServerInterneErro serverInterneErro,
			ConsultaVendaSaidaProcessor consultaVendaSaidaProcessor,
			ConsultaVendaEntradaProcessor consultaVendaEntradaProcessor) {
		this.consultaVendaSaidaProcessor = consultaVendaSaidaProcessor;
		this.consultaVendaEntradaProcessor = consultaVendaEntradaProcessor;
		this.badRequestProcessor = badRequestProcessor;
		this.serverInterneErro = serverInterneErro;
	}
	@Override
	public void configure() throws Exception {
		from(DIRECT_VENDA_ROUTE_ORQUESTRACAO)
			.routeId(ID_VENDA_ROUTE_ORQUESTRACOA)
			.process(consultaVendaEntradaProcessor)
			.doTry()
				.to(VENDA_ROUTE_API)
				.unmarshal().json(JsonLibrary.Jackson,ConsultaVendaSaida.class)
				.process(consultaVendaSaidaProcessor)
			.doCatch(CustumizacaoException.class)
				.process(badRequestProcessor)
			.doCatch(Exception.class)
				.process(serverInterneErro)
		.end();
		
		
	}
	
	
}
