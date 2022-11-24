package com.vendas.repository.query.pedido;

import com.vendas.entity.Pedido;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PedidoRepositoryImpl implements PedidoRepositoryCustom {
  
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public void detach(Pedido pedido) {
    entityManager.detach(pedido);
  }  
    
}
