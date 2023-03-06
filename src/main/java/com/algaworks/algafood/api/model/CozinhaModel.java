package com.algaworks.algafood.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class CozinhaModel {

	private Long id;
	private String nome;
	private Long idRestaurante;

}
