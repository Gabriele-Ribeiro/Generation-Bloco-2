package org.generation.BlogPessoal.repository.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.generation.BlogPessoal.model.Usuario;
import org.generation.BlogPessoal.repository.UsuarioRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRespositoryTest {

	@Autowired
	private UsuarioRepository repository;

	@Test
	public void findByUsuarioRetornaEmail() throws Exception {

		Usuario usuario = repository.findByEmail("gabri@gmail.com").get();
		assertTrue(usuario.getEmail().equals("gabri@gmail.com"));
	}

	@Test
	public void findAllByNomeContainingIgnoreCaseRetornaTresNomes() {

		List<Usuario> listaDeUsuarios = repository.findAllByNomeContainingIgnoreCase("Felipe");
		assertEquals(3, listaDeUsuarios.size());
	}

	@AfterAll
	public void end() {
		repository.deleteAll();
	}
}

