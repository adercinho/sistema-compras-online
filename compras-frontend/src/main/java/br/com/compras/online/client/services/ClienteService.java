package br.com.compras.online.client.services;

import java.util.List;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.online.client.ServiceLocator;

public interface ClienteService extends ServiceLocator<Cliente> {
	List<Cliente> findClientesQueRealizamReservaProdutos();
}
