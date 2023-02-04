package org.generation.blogpessoal.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.blogpessoal.blogpessoal.model.PostagemModel;
import org.generation.blogpessoal.blogpessoal.model.TemaModel;
import org.generation.blogpessoal.blogpessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@PostMapping
    public ResponseEntity<PostagemModel> post(@Valid @RequestBody PostagemModel postagem){
        return ResponseEntity.status(HttpStatus.CREATED)
 	                .body(postagemRepository.save(postagem));
	}
	
	@PutMapping
    public ResponseEntity<PostagemModel> put(@Valid @RequestBody PostagemModel postagem){
        return postagemRepository.findById(postagem.getId())
            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
            .body(postagemRepository.save(postagem)))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<PostagemModel> postagem = postagemRepository.findById(id);
        
        if(postagem.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        postagemRepository.deleteById(id);              
	}
}
	


package org.generation.blogpessoal.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.blogpessoal.blogpessoal.model.TemaModel;
import org.generation.blogpessoal.blogpessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class TemaController {
	@Autowired
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity<List<TemaModel>> getAll(){
		return ResponseEntity.ok(temaRepository.findAll());
	}
	@GetMapping("/{id}")
    public ResponseEntity<TemaModel> getById(@PathVariable Long id){
	 
        return temaRepository.findById(id)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<TemaModel>> getByTitle(@PathVariable 
    String descricao){
        return ResponseEntity.ok(temaRepository
            .findAllByDescricaoContainingIgnoreCase(descricao));
	}
	@PostMapping
    public ResponseEntity<TemaModel> post(@Valid @RequestBody TemaModel tema){
        return ResponseEntity.status(HttpStatus.CREATED)
 	                .body(temaRepository.save(tema));
	}
	@PutMapping
    public ResponseEntity<TemaModel> put(@Valid @RequestBody TemaModel tema){
        return temaRepository.findById(tema.getId())
            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
            .body(temaRepository.save(tema)))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<TemaModel> tema = temaRepository.findById(id);
        
        if(tema.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        temaRepository.deleteById(id);              
    }



}

