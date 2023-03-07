package com.algaworks.algafood.api.model.factory;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Tuple;

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

	public static List<CozinhaModel> converterResultParaModel(List<Tuple> results) {
		return results.stream().map(v->converterResultParaModel(v)).toList();
	}
	
	public static CozinhaModel converterResultParaModel(Tuple result) {
		var model = new CozinhaModel();
		BigInteger id = (BigInteger) result.get("id");
		model.setId(id.longValue());
		String nome = result.get("nome").toString();
		model.setNome(nome);
		return model;
	}
	
}
