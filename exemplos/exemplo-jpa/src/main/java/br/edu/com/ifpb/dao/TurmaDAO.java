package br.edu.com.ifpb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.edu.ifpb.entidades.Turma;

@Stateless
public class TurmaDAO {

	@PersistenceContext(unitName = "dac")
	EntityManager em;

	public void salvar(Turma t) {
		em.persist(t);
	}

	public void atualizar(Turma t) {
		em.merge(t);
	}

	public Turma buscar(Integer id) {
		return em.find(Turma.class, id);
	}

	public List<Turma> buscarTodas() {
		return em.createQuery("SELECT t FROM Turma t", Turma.class).getResultList();
	}
}