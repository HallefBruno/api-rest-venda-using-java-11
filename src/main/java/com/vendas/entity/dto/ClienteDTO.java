package com.vendas.entity.dto;

import com.vendas.entity.Cliente;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
  
  private Integer id;
  private String nome;
  private List<PedidoDTO> pedidos;

  public ClienteDTO() {
  }

  public ClienteDTO(Integer id, String nome, List<PedidoDTO> pedidos) {
   this.id = id;
   this.nome = nome;
   this.pedidos = pedidos;
  }
  
  public ClienteDTO(Cliente cliente) {
    this.id = cliente.getId();
    this.nome = cliente.getNome();
    this.pedidos = cliente.getPedidos().stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());
  }

}
