package br.com.compras.backend.service.ws;

import java.util.List;

import br.com.compras.backend.entity.Produto;

public interface ProdutoService {

	Produto findById(Long id);
	List<Produto> findAll();
	List<Produto> findProdutosMenorQueMilReais();
	Produto save(Produto produto);
	void delete(Long id);
		
}
