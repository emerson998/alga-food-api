package com.algaworks.algafood.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.controller.exceptionhandler.Problema;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroCidadeService cadastroCidade;

	@GetMapping
	public List<Cidade> listar() {

		return cidadeRepository.findAll();
	}

	@GetMapping("/{cidadeId}")
	public Cidade buscar(@PathVariable Long cidadeId) {

		return cadastroCidade.buscarCidadePorId(cidadeId);

	}

	@PostMapping
	public ResponseEntity<Cidade> adicionar(@RequestBody Cidade cidade) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(cadastroCidade.salvar(cidade));
		} catch (EntidadeNaoEncontradaException en) {
			throw new NegocioException(en.getMessage(), en);
		}
	}

	@PutMapping("/{cidadeId}")
	public Cidade atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {

		try {
			Cidade cidadeAtual = cadastroCidade.buscarCidadePorId(cidadeId);

			BeanUtils.copyProperties(cidade, cidadeAtual, "id");

			return cadastroCidade.salvar(cidadeAtual);
		} catch (EstadoNaoEncontradoException en) {
			throw new NegocioException(en.getMessage());
		}
	}

	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<Object> remover(@PathVariable Long cidadeId) {

		cadastroCidade.excluir(cidadeId);

		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<?> handleEstadoNaoEncontradoException(EntidadeNaoEncontradaException e) {

		Problema problema = new Problema();
		problema.setDataHora(LocalDateTime.now());
		problema.setMensagem(e.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

	}

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> handleNegociException(NegocioException ne) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ne.getMessage());

	}
}
