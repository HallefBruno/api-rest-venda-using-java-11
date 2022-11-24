package com.vendas.controller;

import com.vendas.entity.Cliente;
import com.vendas.entity.dto.ClienteDTO;
import com.vendas.service.ClienteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

  private final ClienteService clienteService;

  @PostMapping("/salvar")
  @ResponseStatus(HttpStatus.OK)
  public void salvar(@RequestBody(required = true) ClienteDTO clienteDTO) {
    clienteService.salvar(clienteDTO);
  }
  
  @PutMapping("/atualizar/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void update(@PathVariable(name = "id", required = true) Integer id, @RequestBody(required = true) ClienteDTO clienteDTO) {
    clienteService.update(id, clienteDTO);
  }
  
  @GetMapping("/buscar/{id}")
  public ResponseEntity<ClienteDTO> getCliente(@PathVariable(name = "id", required = true) Integer id) {
    return ResponseEntity.ok(clienteService.getCliente(id));
  }
  
  @GetMapping("/todos")
  public ResponseEntity<List<Cliente>> findAll() {
    return ResponseEntity.ok(clienteService.findAll());
  }
  
  @DeleteMapping("deletar/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletar(@PathVariable(name = "id", required = true) Integer id) {
    clienteService.deletar(id);
  }
  
  @GetMapping("/page")
  public ResponseEntity<Page<Cliente>> page(
    @RequestParam(name = "page", defaultValue = "0", required = true) Integer page, 
    @RequestParam(name = "pageSize", defaultValue = "10", required = true) Integer pageSize) {
    PageRequest pageRequest = PageRequest.of(page, pageSize);
    return ResponseEntity.ok(clienteService.page(pageRequest));
  }
  
}
