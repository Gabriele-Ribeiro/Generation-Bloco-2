package org.generation.BlogPessoal.repository;

import java.util.List;

import org.generation.BlogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);

	public Object findById(Integer id);

	public Object save(String tema);
}
