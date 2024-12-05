package com.lojadegames.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Produtos {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank(message = "O atributo nome é Obrigatorio ")
	@Size(min = 5, max = 20, message = "O atributo nome deve conter no mínimo 05 e no máximo 20 caracteres")
	private String nome;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal preco;
    
    
	@NotBlank(message = "O atributo descrição é Obrigatorio ")
	@Size(min = 15, max = 300, message = "O atributo nome deve conter no mínimo 15 e no máximo 300 caracteres")
	private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    
    public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	

}
