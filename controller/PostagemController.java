package org.generation.blogpessoal.blogpessoal.controller;

import java.util.List;

import org.generation.blogpessoal.blogpessoal.model.PostagemModel;
import org.generation.blogpessoal.blogpessoal.model.TemaModel;
import org.generation.blogpessoal.blogpessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class PostagemController {
	@Autowired
	private PostagemRepository postagemRepository;

	@GetMapping
	public ResponseEntity<List<PostagemModel>> getALL(){
		return ResponseEntity.ok(postagemRepository.findAll());
			
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<PostagemModel> getByTitle(@PathVariable Long id){
        return postagemRepository.findById(id)
          .map(resposta -> ResponseEntity.ok(resposta))
          .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
}
