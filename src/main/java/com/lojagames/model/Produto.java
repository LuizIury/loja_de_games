package com.lojagames.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lojagames.model.Produto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	//id, nome, descrição e preço 
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O espaço nome é obrigatório!")
	@Size(min = 5, max = 100, message = "O espaço nome deve ter no mínimo 5 e no máximo 100 carácteres!")
	@Column(length = 100)
	private String nome_produto;
	
	@Column(name = "descricao_produto")
	@NotBlank(message = "O espaço descrição é obrigatório!")
	private String descricaoProduto;
	
	@NotBlank(message = "O espaço preço é obrigatório!")
	@Size(min = 5, max = 15, message = "O espaço preço deve ter no mínimo 5 e no máximo 15 carácteres!")
	@Column(length = 15)
	private Float preco_produto;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	public Long getId(){
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getDescricao_produto() {
		return descricaoProduto;
	}

	public void setDescricao_produto(String descricao_produto) {
		this.descricaoProduto = descricao_produto;
	}

	public Float getPreco_produto() {
		return preco_produto;
	}

	public void setPreco_produto(Float preco_produto) {
		this.preco_produto = preco_produto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
