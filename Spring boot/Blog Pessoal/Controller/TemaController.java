package org.generation.BlogPessoal.Controller;

import java.util.List;
import java.util.Optional;

import org.generation.BlogPessoal.model.Tema;
import org.generation.BlogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class TemaController {

	@Autowired
	private TemaRepository repository;

	@GetMapping
	public ResponseEntity<List<Tema>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Tema>> GetById(@PathVariable long id) {
		return ResponseEntity.status(200).body(repository.findById(id));
	}

	@GetMapping("/nome{nome}")
	public ResponseEntity<List<Tema>> GetByName(@PathVariable String name) {
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContainingIgnoreCase(name));
	}

	@PostMapping("/salvar")
	public ResponseEntity<Object> post(@RequestBody String tema) {
		return ResponseEntity.status(201).body(repository.save(tema));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Object> put(@RequestBody String tema) {
		return ResponseEntity.status(200).body(repository.save(tema));
	}

	@DeleteMapping("/deletar")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
