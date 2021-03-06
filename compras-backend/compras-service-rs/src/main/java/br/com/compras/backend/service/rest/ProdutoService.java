package br.com.compras.backend.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.compras.backend.entity.Produto;
import br.com.compras.backend.repository.ProdutoRepository;



@RestController
@RequestMapping("/produto")
public class ProdutoService{

	@Autowired
	protected ProdutoRepository repository;
	
	@RequestMapping("/{id}")
	public Produto findById(@PathVariable Long id) {
		return repository.findOne(id);
	}
	
	@RequestMapping
	public List<Produto> findAll() {
		return (List<Produto>) repository.findAll();
	}
	
	@RequestMapping("/findProdutosMenorQueMilReais")
	public List<Produto> findProdutosMenorQueMilReais() {
		return repository.findProdutosMenorQueMilReais();
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
	public Produto save(@RequestBody Produto produto) {
		return repository.save(produto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		repository.delete(repository.findOne(id));
	}
}