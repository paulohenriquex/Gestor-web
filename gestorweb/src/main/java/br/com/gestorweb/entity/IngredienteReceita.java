package br.com.gestorweb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IngredienteReceita {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Double percapita;

  @ManyToOne
  @JoinColumn(name = "produto_id")
  private Produto produto;

  @ManyToOne
  @JoinColumn(name = "receita_id")
  @JsonBackReference
  private Receita receita;

  public void setReceita(Receita receita) {
    this.receita = receita;
  }
}
