package br.com.edu.ifpb.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Telefone implements Serializable {
	
	public Telefone() {
	}

	public Telefone(String codigoCidade, String numero) {
		this.codigoCidade = codigoCidade;
		this.numero = numero;
	}

	@Id
	@GeneratedValue
	private Long id;
	
	private String codigoCidade;
	private String numero;
	
	public String getCodigoCidade() {
		return codigoCidade;
	}
	public void setCodigoCidade(String codigoCidade) {
		this.codigoCidade = codigoCidade;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
