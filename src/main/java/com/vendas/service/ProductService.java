package com.vendas.service;

import com.vendas.entity.Product;
import com.vendas.entity.dto.ProductDTO;
import com.vendas.repository.ProductRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  
  @Transactional(readOnly = true)
  public Page<Product> page(PageRequest pageRequest) {
    Page<Product> page = productRepository.findAll(pageRequest);
    productRepository.findPorductsCategories(page.stream().collect(Collectors.toList()));
    page.map(x -> new ProductDTO(x));
    return page;
  }

}
