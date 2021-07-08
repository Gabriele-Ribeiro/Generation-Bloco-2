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

import com.farmacia.farmacia.Model.ProdutoModel;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired 
	private com.farmacia.farmacia.Services.ProdutoServices services;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> buscarTodos() {
		List<ProdutoModel> listaProduto = services.findAll();
		if (listaProduto.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaProduto);
		}
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<List<ProdutoModel>> buscarId(@PathVariable long id) {
		List<ProdutoModel> listaId = services.findById(id);
		if (listaId.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaId);
		}
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<ProdutoModel>> buscarDescricao(@PathVariable String descricao) {
		List<ProdutoModel> listaDescricao = services.findByDescricao(descricao);
		if (listaDescricao.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDescricao);
		}
	}

	@PostMapping
	public ResponseEntity<Object> salvar(@Valid @RequestBody ProdutoModel novoProduto) {
		Optional<Object> produtoCadastrado = services.criarProduto(novoProduto);

		if (produtoCadastrado.isEmpty()) {
			return ResponseEntity.status(200).body("Produto Existente");
		} else {
			return ResponseEntity.status(201).body("Produto  Criado");
		}
	}

	@PutMapping
	public ResponseEntity<Object> atualizarProduto(@Valid @PathVariable(value = "atualizar_produto") Long atualizarProduto,
			@Valid @RequestBody ProdutoModel produtoParaAtualizar) {
		return services.atualizarProduto(atualizarProduto, produtoParaAtualizar)
				.map(produtoAtualizado -> ResponseEntity.status(201).body(produtoAtualizado))
				.orElse(ResponseEntity.badRequest().build());
	}

	@DeleteMapping
	public ResponseEntity<Object> deletarProduto(@PathVariable(value = "produto_deletar") Long produtoDeletar,
			@Valid @RequestBody ProdutoModel produtoParaDeletar) {
		return services.deletarProduto(produtoDeletar, produtoParaDeletar)
				.map(produtoDeletado -> ResponseEntity.status(201).body(produtoDeletado))
				.orElse(ResponseEntity.badRequest().build());
	}
}
