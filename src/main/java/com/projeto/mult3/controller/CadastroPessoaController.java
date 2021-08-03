package com.projeto.mult3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.mult3.model.CadastroPessoaModel;
import com.projeto.mult3.repository.CadastroPessoaRepository;


@RequestMapping("/cadastrar")
@RestController
public class CadastroPessoaController {
	
	@Autowired
	private CadastroPessoaRepository repository; 
	
	
	@GetMapping("/view")
	public ResponseEntity<List<CadastroPessoaModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
		public ResponseEntity<CadastroPessoaModel> GetById(@PathVariable long id){
			return repository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
		public ResponseEntity<CadastroPessoaModel> post (@RequestBody @Valid CadastroPessoaModel pessoa){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pessoa));
	}
	
	@PutMapping("/edit")
		public ResponseEntity<CadastroPessoaModel> put(@RequestBody @Valid CadastroPessoaModel pessoa){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoa));
	}
	
	@DeleteMapping("/delete/{nome}")
		public void delete(@PathVariable String nome){
			nome = nome.trim();
			repository.deleteByName(nome);
		
	}
}
