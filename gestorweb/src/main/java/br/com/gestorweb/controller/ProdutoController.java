package br.com.gestorweb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestorweb.entity.Produto;
import br.com.gestorweb.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {

  private ProdutoService produtoService;

  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  @PostMapping("/inserir")
  public Produto adicionarProduto(@RequestBody Produto produto) {
    return produtoService.adicionarProduto(produto);
  }

  @GetMapping("/listar")
  public List<Produto> listarProdutos() {
    return produtoService.listarProdutos();
  }
}
