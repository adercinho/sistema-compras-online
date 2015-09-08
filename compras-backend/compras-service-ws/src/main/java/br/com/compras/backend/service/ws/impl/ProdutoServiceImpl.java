package br.com.compras.backend.service.ws.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.compras.backend.entity.Produto;
import br.com.compras.backend.repository.ProdutoRepository;
import br.com.compras.backend.service.ws.ProdutoService;

public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	protected ProdutoRepository repository;
	
	@Override
	public Produto findById(Long id) {
		return repository.findOne(id);
	}
	
	@Override
	public List<Produto> findAll() {
		return (List<Produto>) repository.findAll();
	}
	
	@Override
	public Produto save(Produto produto) {
		return repository.save(produto);
	}
	
	@Override
	public void delete(Long id) {
		repository.delete(repository.findOne(id));
	}
}