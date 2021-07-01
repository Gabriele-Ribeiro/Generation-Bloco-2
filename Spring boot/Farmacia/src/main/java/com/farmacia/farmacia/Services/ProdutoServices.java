package com.farmacia.farmacia.Services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.farmacia.farmacia.Model.ProdutoModel;

public class ProdutoServices {

	public List<ProdutoModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProdutoModel> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProdutoModel> findByDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Object> criarProduto(@Valid ProdutoModel novoProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Object> atualizarProduto(@Valid Long atualizarProduto, @Valid ProdutoModel produtoParaAtualizar) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Object> deletarProduto(Long produtoDeletar, @Valid ProdutoModel produtoParaDeletar) {
		// TODO Auto-generated method stub
		return null;
	}

}
