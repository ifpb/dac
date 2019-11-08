package br.com.edu.ifpb.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Telefone implements Serializable {

	public Telefone() { }
	
	public Telefone(String numero, String tipo) {
		this.numero = numero;
		this.tipo = tipo;
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	private String numero;
	
	private String tipo;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
