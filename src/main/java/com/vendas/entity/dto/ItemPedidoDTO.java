package com.vendas.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoDTO {
    
  private Integer id;
  private PedidoDTO pedido;
  private ProdutoDTO produto;
  private Integer quantidade;

  public ItemPedidoDTO() {
  }
  
  public ItemPedidoDTO(Integer id, PedidoDTO pedido, ProdutoDTO produto, Integer quantidade) {
    this.id = id;
    this.pedido = pedido;
    this.produto = produto;
    this.quantidade = quantidade;
  }
  
}
