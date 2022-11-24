package com.vendas.repository;

import com.vendas.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  
  @Query("SELECT obj FROM Product obj JOIN FETCH obj.categorys WHERE obj IN :categorys")
  List<Product> findPorductsCategories(List<Product> categorys);
  
}
