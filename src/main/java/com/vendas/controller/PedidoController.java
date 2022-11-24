package com.vendas.controller;

import com.vendas.entity.Pedido;
import com.vendas.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
  
  private final PedidoService pedidoService;
    
  @PostMapping("/salvar")
  @ResponseStatus(HttpStatus.OK)
  public void salvar(@RequestBody(required = true) Pedido pedido) {
    pedidoService.salvar(pedido);
  }
  
  @GetMapping("/buscar/{id}")
  public ResponseEntity<Pedido> getPedido(@PathVariable(name = "id", required = true) Integer id) {
    return ResponseEntity.ok(pedidoService.findPedido(id));
  }
  
}
