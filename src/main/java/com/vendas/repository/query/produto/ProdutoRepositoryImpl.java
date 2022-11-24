package com.vendas.repository.query.produto;

import com.vendas.entity.Produto;
import com.vendas.entity.dto.ProdutoDTO;
import com.vendas.repository.query.util.PaginacaoUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;


public class ProdutoRepositoryImpl implements ProdutoRepositoryCustom {
  
  @PersistenceContext 
  private EntityManager em;
  
  @Autowired 
  private PaginacaoUtil paginacaoUtil;
  
  @Autowired
  private ModelMapper modelMapper;
  

  @Override
  public Page<ProdutoDTO> page(PageRequest pageRequest) {
    
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Produto> criteria = cb.createQuery(Produto.class);
    Root<Produto> cliente = criteria.from(Produto.class);
    criteria.select(cliente);
    
    TypedQuery<Produto> typedQuery = em.createQuery(criteria);
    paginacaoUtil.preparar(typedQuery, pageRequest);

    CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
    countQuery.select(cb.count(countQuery.from(Produto.class)));
    Long count = em.createQuery(countQuery).getSingleResult();
    
    Type listType = new TypeToken<List<ProdutoDTO>>(){}.getType();
    List<ProdutoDTO> produtosDTO = modelMapper.map(typedQuery.getResultList(), listType);
    Page<ProdutoDTO> page = new PageImpl<>(produtosDTO, pageRequest, count);
    
    return page;
  }
}
