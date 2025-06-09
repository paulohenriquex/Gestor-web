package br.com.gestorweb.dto;

import java.math.BigDecimal;

import br.com.gestorweb.entity.Produto;

public record ProdutoDTO(Long id, String nome, BigDecimal preco, String medida, String categoria, String marca) {
    public ProdutoDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getMedida(), produto.getCategoria(),
                produto.getMarca());
    }

}
