package br.com.compras.backend.service.ws;

import br.com.compras.backend.entity.Produto;

public interface ProdutoService {

	Produto findById(Long id);
	Produto[] findAll();
	Produto[] findProdutosMenorQueMilReais();
	Produto save(Produto produto);
	void delete(Long id);
		
}
