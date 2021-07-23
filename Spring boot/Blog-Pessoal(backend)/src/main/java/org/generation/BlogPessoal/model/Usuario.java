package org.generation.BlogPessoal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
	
	@Entity
	@Table(name = "usuario")
	public class Usuario {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

		@NotNull
		@Size(min = 2, max = 100)
		private String nome;

		@NotNull
		@Email
		@Size(min = 5, max = 100)
		private String email;

		@NotNull
		@Size(min = 5, max = 100)
		private String senha;

		@OneToMany(mappedBy = "criador", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
		@JsonIgnoreProperties("postagemCriada")
		private List<Postagem> postagemCriada = new ArrayList<>();

		public Usuario() {

		}

		public Usuario(@NotNull @Size(min = 2, max = 100) String nome, @NotNull @Size(min = 5, max = 100) String usuario,
				@NotNull @Size(min = 5, max = 100) String senha) {
			
			super();
			this.nome = nome;
			this.email = email;
			this.senha = senha;
		}
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public List<Postagem> getPostagemCriada() {
			return postagemCriada;
		}

		public void setPostagemCriada(List<Postagem> postagemCriada) {
			this.postagemCriada = postagemCriada;
		}
	}