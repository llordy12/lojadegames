package com.lojadegames.repository;




import org.springframework.data.jpa.repository.JpaRepository;


import com.lojadegames.model.Produtos;

public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
}
