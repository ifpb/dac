package br.edu.com.ifpb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.edu.ifpb.entidades.Faculdade;

@Stateless
public class FaculdadeDAO {

	@PersistenceContext(unitName = "dac")
	EntityManager em;

	public void salvar(Faculdade f) {
		em.persist(f);
	}

	public void atualizar(Faculdade f) {
		em.merge(f);
	}

	public Faculdade buscar(Integer id) {
		return em.find(Faculdade.class, id);
	}

	public List<Faculdade> buscarTodas() {
		return em.createQuery("SELECT f FROM Faculdade f", Faculdade.class).getResultList();
	}
}