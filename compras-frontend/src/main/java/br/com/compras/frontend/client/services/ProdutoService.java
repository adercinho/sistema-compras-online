package br.com.compras.frontend.client.services;

import java.util.List;

import br.com.compras.backend.entity.Produto;

public interface ProdutoService extends AbstractService<Produto> {
	List<Produto> findProdutosMenorQueMilReais();
}
