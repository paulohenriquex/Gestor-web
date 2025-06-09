package br.com.gestorweb.dto;

import br.com.gestorweb.entity.IngredienteReceita;

public record IngredienteReceitaDTO(Long id, Double percapita, ProdutoDTO produto) {
    public IngredienteReceitaDTO(IngredienteReceita ingrediente) {
        this(ingrediente.getId(), ingrediente.getPercapita(), new ProdutoDTO(ingrediente.getProduto()));
    }

}
