package br.edu.ifpb.dac.sessionbean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifpb.dac.domain.Produto;

@Stateless
public class ProdutoService {

	@PersistenceContext(unitName="dac")
	private EntityManager entityManager;
	
	public List<Produto> listarProdutos() {
		return entityManager.createQuery("SELECT p FROM Produto p").getResultList();
	}
	
	public void criarProduto(Produto produto) {
		entityManager.persist(produto);
	}
	
}
