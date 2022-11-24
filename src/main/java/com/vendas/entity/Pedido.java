package com.vendas.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Pedido implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;
  
  @NotNull(message = "Data pedido é obrigatória")
  @Column(nullable = false, name = "data_pedido")
  private LocalDate dataPedido;
  
  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<ItemPedido> itensPedido;
  
  @NotNull(message = "Total é obrigatório")
  @Column(nullable = false, length = 20, precision = 2)
  private BigDecimal total;

}
