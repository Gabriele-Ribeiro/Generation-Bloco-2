package com.farmacia.farmacia.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.farmacia.farmacia.Model.CategoriaModel;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private com.farmacia.farmacia.Services.CategoriaServices services;

	@GetMapping
	public ResponseEntity<List<CategoriaModel>> buscarTodos() {
		List<CategoriaModel> listaCategoria = services.findAll();
		if (listaCategoria.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaCategoria);
		}
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<List<CategoriaModel>> buscarId(@PathVariable long id) {
		List<CategoriaModel> listaId = services.findById(id);
		if (listaId.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaId);
		}
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<CategoriaModel>> buscarDescricao(@PathVariable String descricao) {
		List<CategoriaModel> listaDescricao = services.findByDescricao(descricao);
		if (listaDescricao.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDescricao);
		}
	}

	@PostMapping
	public ResponseEntity<Object> salvar(@Valid @RequestBody CategoriaModel novaCategoria) {
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
			@Valid @RequestBody CategoriaModel categoriaParaAtualizar) {
		return services.atualizarCategoria(atualizarCategoria, categoriaParaAtualizar)
				.map(categoriaAtualizada -> ResponseEntity.status(201).body(categoriaAtualizada))
				.orElse(ResponseEntity.badRequest().build());
	}

	@DeleteMapping
	public ResponseEntity<Object> deletarCategoria(@PathVariable(value = "categoria_deletar") Long categoriaDeletar,
			@Valid @RequestBody CategoriaModel categoriaParaDeletar) {
		return services.atualizarCategoria(categoriaDeletar, categoriaParaDeletar)
				.map(categoriaDeletada -> ResponseEntity.status(201).body(categoriaDeletada))
				.orElse(ResponseEntity.badRequest().build());
	}
}
