
package com.LojaDeGames.Games.Repositories;

import com.LojaDeGames.Games.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}


