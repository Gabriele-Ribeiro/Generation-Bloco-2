package org.generation.BlogPessoal.Controller;

import java.util.List;

import org.generation.BlogPessoal.model.Postagem;
import org.generation.BlogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {
	
	private static final String ResposeEntity = null;
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity <List <Postagem> > GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id")
	public ResponseEntity<Postagem> GetById(@PathVariable Integer id) {
		return ResponseEntity.status(200).body(repository.findById(id));
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> findByTitulo(@PathVariable String titulo){
		return ResponseEntity.status(200).body(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity <Postagem> post (@RequestBody Postagem postagem)
	{
		return ResponseEntity.status(201).body(repository.save(postagem));
	}
	
	@PutMapping ("/atualizar")
	public ResponseEntity<?> put(@RequestBody Postagem postagem){
		return ResponseEntity.status(200).body(repository.save(postagem));
	}
	
	@DeleteMapping("/deletar")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
}
