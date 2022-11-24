package com.vendas.controller;

import com.vendas.entity.dto.ProdutoDTO;
import com.vendas.service.ProdutoService;
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
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
  
  private final ProdutoService produtoService;
  
  @PostMapping("/salvar")
  @ResponseStatus(HttpStatus.CREATED)
  public void salvar(@RequestBody ProdutoDTO dto) {
    produtoService.salvar(dto);
  }
  
  @PutMapping("/atualizar/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void update(@PathVariable(name = "id", required = true) Integer id, @RequestBody ProdutoDTO produtoDTO) {
    produtoService.update(id, produtoDTO);
  }
  
  @GetMapping
  public ResponseEntity<Page<ProdutoDTO>> page(
    @RequestParam(name = "page", defaultValue = "0", required = true) Integer page, 
    @RequestParam(name = "pageSize", defaultValue = "10", required = true) Integer pageSize) {
    PageRequest pageRequest = PageRequest.of(page, pageSize);
    return ResponseEntity.ok(produtoService.page(pageRequest));
  }
  
  @GetMapping("/buscar/{id}")
  public ResponseEntity<ProdutoDTO> getProduto(@PathVariable(name = "id", required = true) Integer id) {
    return ResponseEntity.ok(produtoService.getProdutoDTO(id));
  }
  
  @DeleteMapping("/deletar/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletar(@PathVariable(name = "id", required = true) Integer id) {
    produtoService.deletar(id);
  }
  
}
