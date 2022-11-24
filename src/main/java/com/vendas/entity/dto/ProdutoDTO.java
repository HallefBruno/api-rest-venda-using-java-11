package com.vendas.entity.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

  private Integer id;
  private String descricao;
  private BigDecimal precoUnitario;

  public ProdutoDTO() {
  }
  
  public ProdutoDTO(Integer id, String descricao, BigDecimal precoUnitario) {
    this.id = id;
    this.descricao = descricao;
    this.precoUnitario = precoUnitario;
   }
  
  
}
