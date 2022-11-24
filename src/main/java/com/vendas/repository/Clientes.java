package com.vendas.repository;

import com.vendas.entity.Cliente;
import java.sql.ResultSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Clientes {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public void salvar(Cliente cliente) {
    jdbcTemplate.update("insert into cliente (nome) values(?) ", new Object[]{cliente.getNome()});
  }

  public void atualizar(Cliente cliente) {
    jdbcTemplate.update("update cliente set nome = ? where id = ? ", new Object[]{cliente.getNome(), cliente.getId()});
  }

  public void deletar(Cliente cliente) {
    deletar(cliente.getId());
  }

  public void deletar(Integer id) {
    jdbcTemplate.update("delete cliente where id = ? ", new Object[]{id});
  }

  public List<Cliente> getListClientes() {
    return jdbcTemplate.query("select * from cliente", (ResultSet rs, int rowNum) -> {
      Cliente c = new Cliente();
      c.setId(rs.getInt("id"));
      c.setNome(rs.getString("nome"));
      return c;
    });
  }
}
