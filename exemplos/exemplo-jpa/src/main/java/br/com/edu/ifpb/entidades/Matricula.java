package br.com.edu.ifpb.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Matricula implements Serializable {
	
	public Matricula() {}
	
	public Matricula(String codigo, Date dataMatricula) {
		this.codigo = codigo;
		this.dataMatricula = dataMatricula;
	}



	@Id
	@GeneratedValue
	private Integer id;
	
	private String codigo;
	
	@Temporal(TemporalType.DATE)
	private Date dataMatricula;
	
	@OneToOne
	private Aluno aluno;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
}
