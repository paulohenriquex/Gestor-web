package br.com.gestorweb.dto;

import java.util.List;

import br.com.gestorweb.entity.Receita;

public record ReceitaResponseDTO(Long id, String nome, String modoDePreparo, String categoria,
        List<IngredienteReceitaDTO> ingredientes) {

    public ReceitaResponseDTO(Receita receita) {
        this(receita.getId(),
                receita.getNome(),
                receita.getModoDePreparo(),
                receita.getCategoria(),
                receita.getIngredientes().stream().map(IngredienteReceitaDTO::new).toList());
    }
}
