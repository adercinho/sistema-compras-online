package br.com.compras.online.client.services;

import java.util.List;

import br.com.compras.backend.entity.Produto;
import br.com.compras.online.client.ServiceLocator;

public interface ProdutoService extends ServiceLocator<Produto> {
	List<Produto> findProdutosMenorQueMilReais();
}
