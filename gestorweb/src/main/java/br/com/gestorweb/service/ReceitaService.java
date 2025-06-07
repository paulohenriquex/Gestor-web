package br.com.gestorweb.service;

import org.springframework.stereotype.Service;

import br.com.gestorweb.entity.Receita;
import br.com.gestorweb.repository.ReceitaRepository;

@Service
public class ReceitaService {

  private final ReceitaRepository receitaRepository;

  public ReceitaService(ReceitaRepository receitaRepository) {
    this.receitaRepository = receitaRepository;
  }

  public Receita adicionarReceita(Receita receita) {
    return receitaRepository.save(receita);
  }

  public Receita buscarReceitaPorId(Long id) {
    return receitaRepository.findById(id).orElse(null);
  }
}
