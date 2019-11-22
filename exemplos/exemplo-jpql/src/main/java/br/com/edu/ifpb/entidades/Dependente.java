package br.com.edu.ifpb.entidades;

import javax.persistence.Entity;

@Entity
public class Dependente extends Pessoa {
	
	public enum TipoParentesco { FILHO, MAE, PAI, CONJUGE, OUTROS } 
	
	private TipoParentesco tipoParentesco;

	public TipoParentesco getTipoParentesco() {
		return tipoParentesco;
	}

	public void setTipoParentesco(TipoParentesco tipoParentesco) {
		this.tipoParentesco = tipoParentesco;
	}
	
}
