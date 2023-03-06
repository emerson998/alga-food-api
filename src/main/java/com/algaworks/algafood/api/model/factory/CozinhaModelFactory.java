package com.algaworks.algafood.api.model.factory;

import java.util.List;

import com.algaworks.algafood.api.model.CozinhaModel;
import com.algaworks.algafood.domain.model.Cozinha;

public class CozinhaModelFactory {

	CozinhaModelFactory(){}
	
	public static CozinhaModel converterParaModel (Cozinha entity) {
		var model = new CozinhaModel();
		
		model.setId(entity.getId());
		model.setNome(entity.getNome());
		
		return model;
	}
	
	public static List<CozinhaModel> converterListParaModel(List<Cozinha> cozinhas) {
		return cozinhas.stream().map(CozinhaModelFactory::converterParaModel).toList();
	}
}
