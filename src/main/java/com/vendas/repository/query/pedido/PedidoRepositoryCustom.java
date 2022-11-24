package com.vendas.repository.query.pedido;

import com.vendas.entity.Pedido;

public interface PedidoRepositoryCustom {
  void detach(Pedido pedido);
}
