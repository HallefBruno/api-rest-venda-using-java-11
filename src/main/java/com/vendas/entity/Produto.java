package com.vendas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Produto implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @NotBlank(message = "Descrição obrigatória")
  @Column(length = 200, nullable = false)
  private String descricao;
  
  @Column(name = "preco_unitario", nullable = false)
  @NotNull(message = "Preço unitário obrigatório")
  private BigDecimal precoUnitario;

}
