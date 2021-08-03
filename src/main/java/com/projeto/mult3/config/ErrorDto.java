package com.projeto.mult3.config;

public class ErrorDto {

	private String campo;
	private String erro;
	
	public ErrorDto(String campo, String erro) {
		this.campo = campo; 
		this.erro = erro ;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public String getErro() {
		return erro;
	}
	
}
