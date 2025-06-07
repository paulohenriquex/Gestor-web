package br.com.gestorweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestorweb.entity.Receita;
import br.com.gestorweb.service.ReceitaService;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {
  private final ReceitaService receitaService;

  public ReceitaController(ReceitaService receitaService) {
    this.receitaService = receitaService;
  }

  @PostMapping
  public Receita adicionarReceita(@RequestBody Receita receita) {
    return receitaService.adicionarReceita(receita);
  }

  @GetMapping("/{id}")
  public Receita buscarReceitaPorId(@PathVariable Long id) {
    return receitaService.buscarReceitaPorId(id);
  }
}
