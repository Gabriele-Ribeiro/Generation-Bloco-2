package com.farmacia.farmacia.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O campo não pode ser nulo")
	@Size(min = 1, max = 50)
	private String tipo;
	
	@NotNull(message = "O campo não pode ser nulo")
	@Size(min = 5, max = 130)
	private String descricao;

	@OneToMany(mappedBy = "tipoProduto", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<ProdutoModel> produtosCriados = new ArrayList<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ProdutoModel> getProdutosCriados() {
		return produtosCriados;
	}

	public void setProdutosCriados(List<ProdutoModel> produtosCriados) {
		this.produtosCriados = produtosCriados;
	}
}
