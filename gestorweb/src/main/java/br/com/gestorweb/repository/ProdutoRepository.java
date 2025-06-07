package br.com.gestorweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestorweb.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
  // Métodos adicionais de consulta podem ser definidos aqui, se necessário
}
