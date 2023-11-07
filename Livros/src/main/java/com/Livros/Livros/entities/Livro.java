package com.Livros.Livros.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "/livro")
public class Livro {
	@Id
	@GeneratedValue( strategy  = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size (min = 8, message="Máximo de 2 linhas")
	@Column(name = "descricao")
	private String descricao;
	
	
	@NotNull
	@NotBlank
	@Size (message="Informe o isbn corretamente")
	@Column(name = "isbn")
	private String isbn;
	
	public Livro() {
		
	}

	public Livro(Long id,String descricao,String isbn) {
		this.id =id;
		this.descricao = descricao;
		this.isbn =isbn;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao =descricao;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn =isbn;
	}
	
	
	
}

