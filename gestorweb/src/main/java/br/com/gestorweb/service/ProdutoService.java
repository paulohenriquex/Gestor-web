package br.com.gestorweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gestorweb.entity.Produto;
import br.com.gestorweb.repository.ProdutoRepository;

@Service
public class ProdutoService {

  private ProdutoRepository produtoRepository;

  public ProdutoService(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  public Produto adicionarProduto(Produto produto) {
    return produtoRepository.save(produto);
  }

  public List<Produto> listarProdutos() {
    return produtoRepository.findAll();
  }
}
