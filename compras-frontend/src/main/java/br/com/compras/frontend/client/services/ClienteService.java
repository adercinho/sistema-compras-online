package br.com.compras.frontend.client.services;

import java.util.List;

import br.com.compras.backend.entity.Cliente;

public interface ClienteService extends AbstractService<Cliente> {
	List<Cliente> findClientesQueRealizamReservaProdutos();
}
