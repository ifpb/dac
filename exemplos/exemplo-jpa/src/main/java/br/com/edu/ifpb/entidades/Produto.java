package br.com.edu.ifpb.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {
	
	public Produto() {} 
	
	public Produto(String nome, Float preco) {
		this.nome = nome;
		this.preco = preco;
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	private Float preco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
	
}
