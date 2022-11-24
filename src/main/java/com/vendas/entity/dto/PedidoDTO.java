package com.vendas.entity.dto;

import com.vendas.entity.Pedido;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class PedidoDTO {
  
  private Integer id;
  private ClienteDTO cliente;
  private LocalDate dataPedido;
  private Set<ItemPedidoDTO> itensPedido = new HashSet<>();
  private BigDecimal total;

  public PedidoDTO() {
  }
  
  public PedidoDTO(Integer id, ClienteDTO cliente, LocalDate dataPedido, BigDecimal total) {
    this.id = id;
    this.cliente = cliente;
    this.dataPedido = dataPedido;
    this.total = total;
  }
  
  public PedidoDTO(Pedido pedido) {
    this.cliente = new ModelMapper().map(pedido, ClienteDTO.class);
  }
  
}
