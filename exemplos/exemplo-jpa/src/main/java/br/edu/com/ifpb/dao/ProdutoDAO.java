package br.edu.com.ifpb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.edu.ifpb.entidades.Produto;

@Stateless
public class ProdutoDAO {

	@PersistenceContext(unitName = "dac")
	EntityManager em;

	public void salvar(Produto p) {
		em.persist(p);
	}

	public void atualizar(Produto p) {
		em.merge(p);
	}

	public Produto buscar(Integer id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> buscarTodos() {
		return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
	}
}