package br.edu.com.ifpb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.edu.ifpb.entidades.Evento;
import br.com.edu.ifpb.entidades.EventoPK;
import br.com.edu.ifpb.entidades.Pessoa;

@Stateless
public class EventoDAO {

	@PersistenceContext(unitName = "dac")
	EntityManager em;

	public void salvar(Evento e) {
		em.persist(e);
	}

	public void atualizar(Evento e) {
		em.merge(e);
	}

	public Evento buscar(EventoPK id) {
		return em.find(Evento.class, id);
	}

	public List<Evento> buscarTodas() {
		return em.createQuery("SELECT e FROM Evento e", Evento.class).getResultList();
	}
}