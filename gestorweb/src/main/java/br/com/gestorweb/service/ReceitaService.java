package br.com.gestorweb.service;

import org.springframework.stereotype.Service;
import br.com.gestorweb.dto.ReceitaResponseDTO; // <-- Importar
import br.com.gestorweb.entity.Receita;
import br.com.gestorweb.repository.ReceitaRepository;
import jakarta.transaction.Transactional; // <-- Importar

@Service
public class ReceitaService {

  // ... (seu construtor continua igual)
  private final ReceitaRepository receitaRepository;

  public ReceitaService(ReceitaRepository receitaRepository) {
    this.receitaRepository = receitaRepository;
  }

  @Transactional // Garante que tudo acontece dentro de uma transação
  public Receita adicionarReceita(Receita receita) {
    receita.getIngredientes().forEach(ingrediente -> ingrediente.setReceita(receita));
    return receitaRepository.save(receita);
  }

  // MÉTODO MODIFICADO
  @Transactional // Garante que a sessão fica aberta para carregar os dados lazy
  public ReceitaResponseDTO buscarReceitaPorId(Long id) {
    Receita receita = receitaRepository.findById(id).orElseThrow(() -> new RuntimeException("Receita não encontrada!"));
    // A conversão acontece aqui, dentro da transação, onde o acesso aos dados lazy
    // é permitido
    return new ReceitaResponseDTO(receita);
  }
}
