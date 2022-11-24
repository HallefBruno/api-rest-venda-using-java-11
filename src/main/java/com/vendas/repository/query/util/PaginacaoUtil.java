package com.vendas.repository.query.util;

import javax.persistence.TypedQuery;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class PaginacaoUtil {

  public void preparar(TypedQuery typedQuery, PageRequest pageRequest) {
    int paginaAtual = pageRequest.getPageNumber();
    int totalRegistrosPorPagina = pageRequest.getPageSize();
    int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

    typedQuery.setFirstResult(primeiroRegistro);
    typedQuery.setMaxResults(totalRegistrosPorPagina);

  }

}
