package br.com.edu.ifpb.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Turma implements Serializable {
	
	public Turma() {}
	
	public Turma(String nome) {
		super();
		this.nome = nome;
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	@ManyToMany(mappedBy = "turmas")
	private List<Aluno> alunos;

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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
