package com.vendas.repository;

import com.vendas.entity.Produto;
import com.vendas.repository.query.produto.ProdutoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>, ProdutoRepositoryCustom {
  
}
