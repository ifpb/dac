package br.com.edu.ifpb.entidades;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Auditada {
	private Date dataCriacao;
	private String criador;
	private Date dataUltimaAlteracao;
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getCriador() {
		return criador;
	}
	public void setCriador(String criador) {
		this.criador = criador;
	}
	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}
	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}
	
}
