package org.generation.blogpessoal.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.generation.blogpessoal.blogpessoal.repository.TemaRepository;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_postagem")

public class PostagemModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Preencha o campo")
	@Size(min=1,max=100)
	private String Titulo;

	@NotBlank(message="Preencha o campo")
	@Size(min=1,max=500)
	private String Texto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaModel tema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getTexto() {
		return Texto;
	}

	public void setTexto(String texto) {
		Texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	

}
