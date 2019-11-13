package br.com.edu.ifpb.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Email implements Serializable {
	
	public Email() {
	}

	public Email(String tipo, String email) {
		this.tipo = tipo;
		this.email = email;
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String tipo;
	private String email;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
