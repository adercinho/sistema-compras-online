package br.com.compras.backend.service.ws.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compras.backend.entity.Produto;
import br.com.compras.backend.repository.ProdutoRepository;
import br.com.compras.backend.service.ws.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	protected ProdutoRepository repository;
	
	public Produto findById(Long id) {
		return repository.findOne(id);
	}
	
	public List<Produto> findAll() {
		return (List<Produto>) repository.findAll();
	}
	
	public Produto save(Produto produto) {
		return repository.save(produto);
	}
	
	public void delete(Long id) {
		repository.delete(repository.findOne(id));
	}

	public List<Produto> findProdutosMenorQueMilReais() {
		return repository.findProdutosMenorQueMilReais();
	}
}