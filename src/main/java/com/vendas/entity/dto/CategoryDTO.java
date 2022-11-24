package com.vendas.entity.dto;

import com.vendas.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
  
  private Long id;
  private String nome;
  
  public CategoryDTO(Category category) {
    this.id = category.getId();
    this.nome = category.getNome();
  }
  
}
