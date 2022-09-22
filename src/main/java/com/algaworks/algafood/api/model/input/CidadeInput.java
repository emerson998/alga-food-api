package com.algaworks.algafood.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CidadeInput {

	@NotBlank
	private String nome;

	@Valid
	@NotNull
	private EstadoIdInput estado;


}
