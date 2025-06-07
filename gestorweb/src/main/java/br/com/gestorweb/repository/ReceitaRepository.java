package br.com.gestorweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestorweb.entity.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
  // Métodos adicionais de consulta podem ser definidos aqui, se necessário
}
