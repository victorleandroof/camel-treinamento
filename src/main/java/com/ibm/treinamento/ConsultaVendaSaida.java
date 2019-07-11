package com.ibm.treinamento;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsultaVendaSaida {

	@JsonProperty("codigo")
	private long codigo;
	@JsonProperty("desconto")
	private double desconto;
	@JsonProperty("itens")
	private List<ItensVendaSaida> itens;
	@JsonProperty("codigo_usuario")
	private long codigoUsuario;
	@JsonProperty("tipo_pagamento")
	private TipoPagamentoVendaSaida tipoPagamento;
	
	public float getCodigo() {
		return codigo;
	}

	public double getDesconto() {
		return desconto;
	}

	public float getCodigoUsuario() {
		return codigoUsuario;
	}

	public TipoPagamentoVendaSaida getTipoPagamento() {
		return tipoPagamento;
	}

	public List<ItensVendaSaida> getItens() {
		return itens;
	}
	// Setter Methods

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public void setCodigoUsuario(long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public void setTipoPagamento(TipoPagamentoVendaSaida tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
}
