package br.edu.com.ifpb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.edu.ifpb.entidades.Pessoa;

@Stateless
public class PessoaDAO {

	@PersistenceContext(unitName = "dac")
	EntityManager em;

	public void salvar(Pessoa p) {
		em.persist(p);
	}

	public void atualizar(Pessoa p) {
		em.merge(p);
	}

	public Pessoa buscar(int id) {
		return em.find(Pessoa.class, id);
	}

	public List<Pessoa> buscarTodas() {
		return em.createQuery("SELECT p FROM Pessoa p ORDER BY p.id", Pessoa.class).getResultList();
	}
}