package com.lojadegames.repository;

import com.lojadegames.model.Categoria;




import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
