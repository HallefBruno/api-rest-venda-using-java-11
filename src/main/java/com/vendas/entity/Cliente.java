package com.vendas.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Cliente implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @NotBlank(message = "Nome é obrigatório")
  @Column(length = 255, nullable = false)
  private String nome;
  
  @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
  private Set<Pedido> pedidos = new HashSet<>();


}
