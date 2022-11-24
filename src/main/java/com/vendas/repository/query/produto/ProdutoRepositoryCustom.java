package com.vendas.repository.query.produto;

import com.vendas.entity.dto.ProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ProdutoRepositoryCustom {

  Page<ProdutoDTO> page(PageRequest pageRequest);
}
