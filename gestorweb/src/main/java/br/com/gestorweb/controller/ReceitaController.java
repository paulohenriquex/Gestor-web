package br.com.gestorweb.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestorweb.dto.ReceitaResponseDTO;
import br.com.gestorweb.entity.Receita;
import br.com.gestorweb.service.ReceitaService;

@RestController
@RequestMapping("/api/receitas")
@CrossOrigin(origins = "http://localhost:4200")
public class ReceitaController {
  // ... (seu construtor continua igual)
  private final ReceitaService receitaService;

  public ReceitaController(ReceitaService receitaService) {
    this.receitaService = receitaService;
  }

  // O POST continua igual, recebendo a entidade completa
  @PostMapping("/inserir")
  public Receita adicionarReceita(@RequestBody Receita receita) {
    return receitaService.adicionarReceita(receita);
  }

  // O GET AGORA RETORNA O DTO
  @GetMapping("/{id}")
  public ReceitaResponseDTO obterReceitaPorId(@PathVariable Long id) {
    return receitaService.buscarReceitaPorId(id);
  }
}
