package com.ibm.treinamento;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipoPagamentoVendaSaida {
	
	@JsonProperty("tipo")
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
