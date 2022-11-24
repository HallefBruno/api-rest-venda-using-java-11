package com.vendas.repository.query.cliente;

import com.vendas.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


public interface ClienteRepositoryCustom {
  Page<Cliente> todos(PageRequest pageRequest);
}
