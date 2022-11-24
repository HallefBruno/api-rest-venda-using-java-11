package com.vendas.service;

import com.vendas.entity.ItemPedido;
import com.vendas.entity.Pedido;
import com.vendas.entity.Produto;
import com.vendas.entity.dto.PedidoDTO;
import com.vendas.entity.dto.PedidoDTO;
import com.vendas.repository.PedidoRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PedidoService {
    
  private final PedidoRepository pedidoRepository;
  private final ProdutoService produtoService;
  private final ModelMapper modelMapper;
  
  @Transactional
  public void salvar(Pedido pedido) {
    BigDecimal total = BigDecimal.ZERO;
    for(ItemPedido itemPedido : pedido.getItensPedido()) {
      Produto produto = produtoService.getProduto(itemPedido.getProduto().getId());
      total = total.add(produto.getPrecoUnitario().multiply(new BigDecimal(itemPedido.getQuantidade())));
    }
    pedido.setTotal(total);
    pedido.setDataPedido(LocalDate.now());
    pedidoRepository.save(pedido);
  }
  
  public Pedido findPedido(Integer id) {
    return pedidoRepository.findById(id).map(pedido -> {
      return pedido;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado para o identificador: "+id));
  }

}
