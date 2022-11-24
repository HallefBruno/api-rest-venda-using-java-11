package com.vendas.repository;

import com.vendas.entity.Pedido;
import com.vendas.repository.query.pedido.PedidoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>, PedidoRepositoryCustom {
  
}
