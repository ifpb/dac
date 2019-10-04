package br.edu.ifpb.dac.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifpb.dac.domain.Produto;
import br.edu.ifpb.dac.sessionbean.ProdutoService;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	@EJB
	private ProdutoService produtoService;
	
	private List<Produto> produtos;
	
	private Produto produto = new Produto();
	
	@PostConstruct
	public void init() {
		carregarProdutos();
	}
	
	public void carregarProdutos() {
		this.produtos = produtoService.listarProdutos();
	}
	
	public void salvarProduto() {
		produtoService.criarProduto(produto);
		this.produto = new Produto();
		carregarProdutos();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
