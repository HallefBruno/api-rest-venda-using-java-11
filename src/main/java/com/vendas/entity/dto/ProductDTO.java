package com.vendas.entity.dto;

import com.vendas.entity.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

  private Long id;
  private String nome;
  private List<CategoryDTO> categories = new ArrayList<>();

  public ProductDTO() {
  }

  public ProductDTO(Long id, String nome, List<CategoryDTO> categories) {
    this.id = id;
    this.nome = nome;
    this.categories = categories;
  }

  public ProductDTO(Product product) {
    this.id = product.getId();
    this.nome = product.getNome();
    this.categories = product.getCategorys().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
  }

}
