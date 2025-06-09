package br.com.gestorweb.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
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
public class Receita {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String modoDePreparo;
  private String categoria;
  @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<IngredienteReceita> ingredientes;

  public List<IngredienteReceita> getIngredientes() {
    return ingredientes;
  }

  public Long getId() {
    return id;
  }
}
