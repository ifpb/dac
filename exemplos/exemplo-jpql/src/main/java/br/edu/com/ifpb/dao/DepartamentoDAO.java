package br.edu.com.ifpb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.edu.ifpb.entidades.Departamento;

@Stateless
public class DepartamentoDAO {

	@PersistenceContext(unitName = "dac")
	EntityManager em;

	public void salvar(Departamento d) {
		em.persist(d);
	}

	public void atualizar(Departamento d) {
		em.merge(d);
	}

	public Departamento buscar(Long id) {
		return em.find(Departamento.class, id);
	}

	public List<Departamento> buscarTodas() {
		return em.createQuery("SELECT d FROM Departamento d ORDER BY d.id", Departamento.class).getResultList();
	}
	
	public Departamento buscarPorAbreviacao(String abreviacao) {
		Query query = em.createQuery("SELECT d FROM Departamento d WHERE d.abreviacao = :abreviacao");
		query.setMaxResults(1);
		query.setParameter("abreviacao", abreviacao);
		return (Departamento)query.getSingleResult();
	}
	
}