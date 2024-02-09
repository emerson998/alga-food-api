package com.algaworks.algafood.domain.service;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.algaworks.algafood.domain.model.Cozinha;

public class SpecificationTeste implements Specification<Cozinha>{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	
	public SpecificationTeste(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public Predicate toPredicate(Root<Cozinha> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
		var condicoes = new ArrayList<Predicate>();
		
		if(id != null) {
			Predicate equalId = criteriaBuilder.equal(root.get("id"), id);
			condicoes.add(equalId);
		}
		
		if(nome != null && !nome.isBlank()) {
			Predicate likeNome = criteriaBuilder.like(root.get("nome"), nome.concat("%"));
			condicoes.add(likeNome);
		}
		
		
		return criteriaBuilder.and(condicoes.toArray(new Predicate[0]));
	}

}
