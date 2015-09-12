package br.com.compras.frontend.client.services;

import java.util.List;

import br.com.compras.backend.entity.Compra;

public interface CompraService extends AbstractService<Compra> {
	List<Compra> findComprasMaiorQueQuinhentosReais();
}
