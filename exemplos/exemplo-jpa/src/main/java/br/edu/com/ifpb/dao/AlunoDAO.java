package br.edu.com.ifpb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.edu.ifpb.entidades.Aluno;
import br.com.edu.ifpb.entidades.Evento;

@Stateless
public class AlunoDAO {

	@PersistenceContext(unitName = "dac")
	EntityManager em;

	public void salvar(Aluno a) {
		em.persist(a);
	}

	public void atualizar(Aluno a) {
		em.merge(a);
	}

	public Aluno buscar(Integer id) {
		return em.find(Aluno.class, id);
	}

	public List<Aluno> buscarTodas() {
		return em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
	}
}