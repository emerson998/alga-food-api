package com.algaworks.algafood.api.controller.exceptionhandler;

import java.time.LocalDateTime;

public class Problema {

	private LocalDateTime dataHora;

	private String mensagem;

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
