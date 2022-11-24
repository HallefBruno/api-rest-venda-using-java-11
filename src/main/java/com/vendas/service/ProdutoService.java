package com.vendas.service;

import com.vendas.util.VendasUtil;
import com.vendas.entity.Produto;
import com.vendas.entity.dto.ProdutoDTO;
import com.vendas.repository.ProdutoRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProdutoService {
  
  private final ProdutoRepository produtoRepository;
  private final ModelMapper modelMapper;
  
  @Transactional
  public void salvar(ProdutoDTO dto) {
    Produto produto = modelMapper.map(dto, Produto.class);
    produtoRepository.save(produto);
  }
  
  @Transactional
  public void update(Integer id, ProdutoDTO produtoDTO) {
    isValidId(id);
    produtoRepository.findById(id).map(produtoAtual -> {
      VendasUtil.copyProperties(produtoDTO, produtoAtual);
      produtoAtual.setId(id);
      produtoRepository.save(produtoAtual);
      return Void.TYPE;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado para o identificador: "+id));
  }
  
  public ProdutoDTO getProdutoDTO(Integer id) {
    isValidId(id);
    return produtoRepository.findById(id).map(produtoAtual -> {
      ProdutoDTO produtoDTO = modelMapper.map(produtoAtual, ProdutoDTO.class);
      return produtoDTO;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado para o identificador: "+id));
  }
  
  
  public Produto getProduto(Integer id) {
    isValidId(id);
    return produtoRepository.findById(id).map(produtoAtual -> {
      Produto produto = modelMapper.map(produtoAtual, Produto.class);
      return produto;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado para o identificador: "+id));
  }
  
  @Transactional
  public void deletar(Integer id) {
    isValidId(id);
    produtoRepository.findById(id).map(produtoAtual -> {
      produtoRepository.delete(produtoAtual);
      return Void.TYPE;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado para o identificador: "+id));
  }
  
  @Transactional
  public void deletar(ProdutoDTO produtoDTO) {
    produtoRepository.deleteById(produtoDTO.getId());
  }
  
  public Page<ProdutoDTO> page(PageRequest pageRequest) {
    return produtoRepository.page(pageRequest);
  }
  
  private void isValidId(final Integer id) {
    if(Objects.isNull(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador inválido");
  }
  
}
