package com.ibm.treinamento;

public class CustumizacaoException extends Exception {

	private static final long serialVersionUID = -4802834900157641534L;
	private String texto;
	
	public CustumizacaoException(String texto) {
		super(texto);
		this.texto = texto;
	}
	public String toString(){
		return texto;
	}
	public String getTexto() {
		return texto;
	}
}
