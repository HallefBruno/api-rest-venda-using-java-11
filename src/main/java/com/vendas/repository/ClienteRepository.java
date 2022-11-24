package com.vendas.repository;

import com.vendas.entity.Cliente;
import com.vendas.repository.query.cliente.ClienteRepositoryCustom;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>, ClienteRepositoryCustom {

  Optional<Cliente> findOneByNome(String nome);
  Optional<Cliente> findByNomeLike(String nome);
  Boolean existsByNome(String nome);
  
}
