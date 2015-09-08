package br.com.compras.backend.service.ws;

import java.util.List;

import br.com.compras.backend.entity.Cliente;

public interface ClienteService {

	Cliente findById(Long id);
	List<Cliente> findAll();
	List<Cliente> findClientesQueRealizamReservaProdutos();
	Cliente save(Cliente cliente);
	void delete(Long id);
		
}
