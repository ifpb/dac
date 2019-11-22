package br.com.edu.ifpb.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Funcionario extends Pessoa {
	
	private Float salario;
	private Date admissao;
	private String matricula;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Dependente> dependentes;
	
	@ManyToOne
	private Departamento departamento;
	
	public Float getSalario() {
		return salario;
	}
	public void setSalario(Float salario) {
		this.salario = salario;
	}
	public Date getAdmissao() {
		return admissao;
	}
	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public List<Dependente> getDependentes() {
		return dependentes;
	}
	public void addDependente(Dependente dependente) {
		if (this.dependentes == null) {
			this.dependentes = new ArrayList();
		}
		this.dependentes.add(dependente);
	}
	public void removeDependente(Dependente dependente) {
		this.dependentes.remove(dependente);
	}
	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
