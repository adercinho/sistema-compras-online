package br.com.compras.backend.service.ws.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.compras.backend.entity.Produto;
import br.com.compras.backend.repository.ProdutoRepository;
import br.com.compras.backend.service.ws.ProdutoService;

@WebService(endpointInterface = "br.com.compras.backend.service.ws.ProdutoService")
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	protected ProdutoRepository repository;
	
	public Produto findById(Long id) {
		return repository.findOne(id);
	}
	
	public Produto[] findAll() {
		List<Produto> lista = (List<Produto>) repository.findAll();
		return lista.toArray(new Produto[lista.size()]);
	}
	
	public Produto save(Produto produto) {
		return repository.save(produto);
	}
	
	public void delete(Long id) {
		repository.delete(repository.findOne(id));
	}

	public Produto[] findProdutosMenorQueMilReais() {
		List<Produto> lista = repository.findProdutosMenorQueMilReais();
		return lista.toArray(new Produto[lista.size()]);
	}
}