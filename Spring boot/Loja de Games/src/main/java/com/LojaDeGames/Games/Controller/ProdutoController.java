package com.LojaDeGames.Games.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.LojaDeGames.Games.model.Produto;
import com.LojaDeGames.Games.Services.ProdutoService;
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
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired 
	private ProdutoService services;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Produto>> buscarTodos() {
		List<Produto> listaProduto = services.findAll();
		if (listaProduto.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaProduto);
		}
	}

	@GetMapping("/id")
	public ResponseEntity<List<Produto>> buscarId(@PathVariable long id) {
		List<Produto> listaId = services.findById(id);
		if (listaId.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaId);
		}
	}

	@GetMapping("/descricao")
	public ResponseEntity<List<Produto>> buscarDescricao(@PathVariable String descricao) {
		List<Produto> listaDescricao = services.findByDescricao(descricao);
		if (listaDescricao.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDescricao);
		}
	}

	@PostMapping("/criar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Produto novoProduto) {
		Optional<Object> produtoCadastrado = services.criarProduto(novoProduto);

		if (produtoCadastrado.isEmpty()) {
			return ResponseEntity.status(200).body("Produto Existente");
		} else {
			return ResponseEntity.status(201).body("Produto  Criado");
		}
	}

	@PutMapping("/{produto}/atualizarProduto")
	public ResponseEntity<Object> atualizarProduto(@Valid @PathVariable(value = "atualizar_produto") Long atualizarProduto,
			@Valid @RequestBody Produto produtoParaAtualizar) {
		return services.atualizarProduto(atualizarProduto, produtoParaAtualizar)
				.map(produtoAtualizado -> ResponseEntity.status(201).body(produtoAtualizado))
				.orElse(ResponseEntity.badRequest().build());
	}

	@DeleteMapping("/{produto}/Deletar")
	public ResponseEntity<Object> deletarProduto(@PathVariable(value = "produto_deletar") Long produtoDeletar,
			@Valid @RequestBody Produto produtoParaDeletar) {
		return services.deletarProduto(produtoDeletar, produtoParaDeletar)
				.map(produtoDeletado -> ResponseEntity.status(201).body(produtoDeletado))
				.orElse(ResponseEntity.badRequest().build());
	}

}
