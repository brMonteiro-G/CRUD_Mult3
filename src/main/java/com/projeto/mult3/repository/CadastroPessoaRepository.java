package com.projeto.mult3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.mult3.model.CadastroPessoaModel;

@Repository
public interface CadastroPessoaRepository extends JpaRepository<CadastroPessoaModel,Long> {
	

	@Modifying
	@Transactional
	@Query("DELETE FROM CadastroPessoaModel p WHERE p.nome = :nome ")
	public void deleteByName( @Param("nome") String nome);
	

	
}
