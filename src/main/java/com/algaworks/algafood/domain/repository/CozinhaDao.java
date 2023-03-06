package com.algaworks.algafood.domain.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.api.model.CozinhaModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CozinhaDao {

	private final JdbcTemplate jdbcTemplate;

	public List<CozinhaModel> buscarCozinhasPorIdAndNome(Long id, String nome) {
		var sb = new StringBuilder();

		sb.append("SELECT * FROM tb_cozinha cozinha WHERE id = ").append(id).append(" and nome like '").append(nome)
				.append("%'");

		return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<>(CozinhaModel.class));
	}
}
