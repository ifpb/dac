package br.edu.com.ifpb.dao;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.edu.ifpb.entidades.Funcionario;

@Stateless
public class FuncionarioDAO extends PessoaDAO {

	public Funcionario buscarPorCPF(String cpf) {
		Query query = em.createQuery("SELECT f FROM Funcionario f WHERE f.cpf = :cpf");
		query.setMaxResults(1);
		query.setParameter("cpf", cpf);
		return (Funcionario) query.getSingleResult();
	}
	
}