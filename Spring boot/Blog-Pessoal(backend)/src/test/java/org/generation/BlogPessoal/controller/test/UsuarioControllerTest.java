package org.generation.BlogPessoal.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.generation.BlogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private Usuario usuario;
	private Usuario usuarioAlterar;
	
	@BeforeAll
	public void start() {
		usuario = new Usuario("Gabi", "gabi@gmail.com", "1234567");
		usuarioAlterar = new Usuario("Gabri", "gabri@gmail.com", "7654321");
	}

	@Disabled
	@Test
	void deveSalvarUsuarioRetornaStatus201() {
		
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario);
		
		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuario/salvar", HttpMethod.POST, request, Usuario.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	void deveRetornarListadeUsuarioRetornaStatus200() {
		
		ResponseEntity<String> resposta = testRestTemplate
				.exchange("/usuario/todos", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}

	@Disabled
	@Test
	public void deveRealizarDeleteUsuarios() {
		ResponseEntity<String> resposta = testRestTemplate.exchange("/usuarios/3", HttpMethod.DELETE, null,
				String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}

}
