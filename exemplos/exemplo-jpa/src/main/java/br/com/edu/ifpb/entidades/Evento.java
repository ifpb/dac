package br.com.edu.ifpb.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "eventos")
@IdClass(EventoPK.class)
public class Evento implements Serializable {

	public enum TipoEvento { CONGRESSO, SIMPOSIO };
	
//	@EmbeddedId
//	private EventoPK pk;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 150, nullable = false)
	@Id
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Enumerated(EnumType.STRING)
	private TipoEvento tipo;
	
	@Column(columnDefinition = "text")
	private String descricao;
	
	@Column(precision = 2)
	private Float inscricao;
	
	
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public TipoEvento getTipo() {
		return tipo;
	}
	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Float getInscricao() {
		return inscricao;
	}
	public void setInscricao(Float inscricao) {
		this.inscricao = inscricao;
	}
	
	
	
}
