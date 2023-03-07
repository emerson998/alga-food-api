package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Tuple;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.api.model.CozinhaModel;
import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

	List<Cozinha> findTodasByNomeContaining(String nome);
	
	Optional<Cozinha> findByNome(String nome);
	
	boolean existsByNome(String nome);

	List<Cozinha> findAll(Specification<Cozinha> specs);

	List<Cozinha> findAllByIdAndNome(Long id, String nome);
	
	@Query("select cozinha from Cozinha cozinha "
			+ " where cozinha.id = :id and cozinha.nome = :nome")
	List<Cozinha> findAllByIdAndNomeJpql(Long id, String nome);

	@Query("SELECT new com.algaworks.algafood.api.model.CozinhaModel(cozinha.id , cozinha.nome , restaurante.id as idRestaurante ) "
			+ " FROM Cozinha cozinha "
			+ " LEFT JOIN cozinha.restaurantes restaurante ")
	List<CozinhaModel> findAllCozinhaResultDto();

	@Query(value =" SELECT cozinha.id as id ,cozinha.nome as nome FROM tb_cozinha cozinha " , nativeQuery = true)
	List<Tuple> findAllNative();
	
	@Query(value =" SELECT cozinha.id as id ,cozinha.nome as nome FROM tb_cozinha cozinha " , nativeQuery = true)
	List<Object[]> findAllNativeVetor();


	

}
