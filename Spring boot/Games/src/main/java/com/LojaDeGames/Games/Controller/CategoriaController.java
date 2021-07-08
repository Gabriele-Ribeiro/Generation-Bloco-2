package com.LojaDeGames.Games.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.LojaDeGames.Games.model.Categoria;
import com.LojaDeGames.Games.Services.CategoriaService;
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
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaService services;

	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos() {
		List<Categoria> listaCategoria = services.findAll();
		if (listaCategoria.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaCategoria);
		}
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<List<Categoria>> buscarId(@PathVariable long id) {
		List<Categoria> listaId = services.findById(id);
		if (listaId.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaId);
		}
	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categoria>> buscarTipo(@PathVariable String tipo) {
		List<Categoria> listaTipo = services.findByTipo(tipo);
		if (listaTipo.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaTipo);
		}
	}

	@PostMapping
	public ResponseEntity<Object> salvar(@Valid @RequestBody Categoria novaCategoria) {
		Optional<Object> categoriaCadastrada = services.criarCategoria(novaCategoria);

		if (categoriaCadastrada.isEmpty()) {
			return ResponseEntity.status(200).body("Categoria Existente");
		} else {
			return ResponseEntity.status(201).body("Categoria  Criado");
		}
	}

	@PutMapping
	public ResponseEntity<Object> atualizarCategoria(
			@Valid @PathVariable(value = "atualizar_categoria") Long atualizarCategoria,
			@Valid @RequestBody Categoria categoriaParaAtualizar) {
		return services.atualizarCategoria(atualizarCategoria, categoriaParaAtualizar)
				.map(categoriaAtualizada -> ResponseEntity.status(201).body(categoriaAtualizada))
				.orElse(ResponseEntity.badRequest().build());
	}

	@DeleteMapping
	public ResponseEntity<Object> deletarCategoria(@PathVariable(value = "categoria_deletar") Long categoriaDeletar,
			@Valid @RequestBody Categoria categoriaParaDeletar) {
		return services.deletarCategoria(categoriaDeletar, categoriaParaDeletar)
				.map(categoriaDeletada -> ResponseEntity.status(201).body(categoriaDeletada))
				.orElse(ResponseEntity.badRequest().build());
	}

}
