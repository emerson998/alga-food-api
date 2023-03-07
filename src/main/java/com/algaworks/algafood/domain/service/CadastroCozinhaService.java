package com.algaworks.algafood.domain.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.api.model.CozinhaModel;
import com.algaworks.algafood.api.model.CozinhaModelRecord;
import com.algaworks.algafood.api.model.factory.CozinhaModelFactory;
import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaDao;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	private static final String MSG_COZINHA_EM_USO 
		= "Cozinha de código %d não pode ser removida, pois está em uso";

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired 
	private CozinhaDao cozinhaDao;
	
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}
	
	@Transactional
	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.deleteById(cozinhaId);
			cozinhaRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new CozinhaNaoEncontradaException(cozinhaId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_COZINHA_EM_USO, cozinhaId));
		}
	}
	
	public Cozinha buscarCozinhaPorId(Long cozinhaId) {
		return cozinhaRepository.findById(cozinhaId)
			.orElseThrow(() -> new CozinhaNaoEncontradaException(cozinhaId));
	}

	public List<CozinhaModel> buscarCozinhasPorFiltroCriteria(Long id, String nome) {
		List<Cozinha> cozinhas = cozinhaRepository.findAll(new SpecificationTeste(id , nome));
		return CozinhaModelFactory.converterListParaModel(cozinhas);
	}

	public List<CozinhaModel> buscarCozinhasPorFiltroMicroQuery(Long id, String nome) {
		List<Cozinha> cozinhas = cozinhaRepository.findAllByIdAndNome(id , nome);
		return CozinhaModelFactory.converterListParaModel(cozinhas);
	}
	
	public List<CozinhaModel> buscarCozinhasPorFiltroJpql(Long id, String nome) {
		List<Cozinha> cozinhas = cozinhaRepository.findAllByIdAndNomeJpql(id , nome);
		return CozinhaModelFactory.converterListParaModel(cozinhas);
	}

	public List<CozinhaModel> buscarCozinhasPorFiltroNative(Long id, String nome) {
		
		return cozinhaDao.buscarCozinhasPorIdAndNome(id, nome);
	}

	public List<CozinhaModel> buscarCozinhaProjectDto() {
		return cozinhaRepository.findAllCozinhaResultDto();
	}

	public List<CozinhaModel> buscarCozinhaProjectTuple() {
		List<Tuple> result = cozinhaRepository.findAllNative();
		return CozinhaModelFactory.converterResultParaModel(result);
	}

	public List<CozinhaModelRecord> buscarCozinhaRecord() {
		List<CozinhaModelRecord> retorno = new ArrayList<>();
		List<Cozinha> results = cozinhaRepository.findAll();
		if(!results.isEmpty()) {
		results.forEach(r -> retorno.add(new CozinhaModelRecord(r.getId(), r.getNome())));
		}
		return retorno;
	}

	public List<CozinhaModel> buscarCozinhaProjecaoVetorObject() {
		List<CozinhaModel> retorno = new ArrayList<>();

		List<Object[]> results = cozinhaRepository.findAllNativeVetor();
		results.forEach(arr -> {
			BigInteger id = ((BigInteger) arr[0]);
			var model = new CozinhaModel();
			model.setId(id.longValue());
			model.setNome((String) arr[1]);
			retorno.add(model);
		});
		return retorno;

	}


	
}