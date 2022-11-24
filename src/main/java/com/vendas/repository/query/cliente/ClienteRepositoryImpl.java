package com.vendas.repository.query.cliente;

import com.vendas.entity.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class ClienteRepositoryImpl {

  @PersistenceContext
  private EntityManager em;

  public Page<Cliente> todos(PageRequest pageRequest) {

    int paginaAtual = pageRequest.getPageNumber();
    int totalRegistrosPorPagina = pageRequest.getPageSize();
    int pagina = paginaAtual * totalRegistrosPorPagina;

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Cliente> criteria = cb.createQuery(Cliente.class);
    Root<Cliente> cliente = criteria.from(Cliente.class);
    cliente.fetch("pedidos", JoinType.LEFT);

    criteria.select(cliente);

    TypedQuery<Cliente> typedQuery = em.createQuery(criteria);
    typedQuery.setFirstResult(pagina);
    typedQuery.setMaxResults(totalRegistrosPorPagina);

    CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
    countQuery.select(cb.count(countQuery.from(Cliente.class)));
    Long count = em.createQuery(countQuery).getSingleResult();

    Page<Cliente> page = new PageImpl<>(typedQuery.getResultList(), pageRequest, count);

    return page;
  }

}
