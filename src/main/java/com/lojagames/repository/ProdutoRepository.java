package com.lojagames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.lojagames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findAllByDescricaoProdutoContainingIgnoreCase(@Param("descricaoProduto") String descricaoProduto);
	
}
