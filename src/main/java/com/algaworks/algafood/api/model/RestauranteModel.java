package com.algaworks.algafood.api.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RestauranteModel {

	private Long id;
	private String nome;
	private BigDecimal taxaFrete;
	private CozinhaModel cozinha;

}
