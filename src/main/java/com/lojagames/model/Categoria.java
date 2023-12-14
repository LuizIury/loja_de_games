package com.lojagames.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lojagames.model.Categoria;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	//id, ícone, nome e descrição 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 1000, message = "O atributo texto deve conter no máximo 1000 caracteres") 
	private String icone_categoria;
	
	@NotBlank(message = "O espaço nome é obrigatório!")
	@Size(min = 5, max = 100, message = "O espaço nome deve ter no mínimo 5 e no máximo 100 carácteres!")
	@Column(length = 100)
	private String nome_categoria;
	
	@NotBlank(message = "O espaço descrição é obrigatório!")
	private String descricao_categoria;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIcone_categoria() {
		return icone_categoria;
	}

	public void setIcone_categoria(String icone_categoria) {
		this.icone_categoria = icone_categoria;
	}

	public String getNome_categoria() {
		return nome_categoria;
	}

	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}

	public String getDescricao_categoria() {
		return descricao_categoria;
	}

	public void setDescricao_categoria(String descricao_categoria) {
		this.descricao_categoria = descricao_categoria;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
}
