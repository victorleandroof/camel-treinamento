package com.ibm.treinamento;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItensVendaSaida {
	
	@JsonProperty("quantidade")
	private int quantidade;
	@JsonProperty("codigo_venda")
	private long codigoVenda;
	@JsonProperty("codigo_produto")
	private long codigoProduto;
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public long getCodigoVenda() {
		return codigoVenda;
	}
	public void setCodigoVenda(long codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
	public long getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	
}
