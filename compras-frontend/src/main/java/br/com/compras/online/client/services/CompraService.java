package br.com.compras.online.client.services;

import java.util.List;

import br.com.compras.backend.entity.Compra;
import br.com.compras.online.client.ServiceLocator;

public interface CompraService extends ServiceLocator<Compra> {
	List<Compra> findComprasMaiorQueQuinhentosReais();
}
