package br.com.compras.backend.service.ws;

import javax.jws.WebService;

import br.com.compras.backend.entity.Cliente;

@WebService
public interface ClienteService {

	Cliente findById(Long id);
	Cliente[] findAll();
	Cliente[] findClientesQueRealizamReservaProdutos();
	Cliente save(Cliente cliente);
	void delete(Long id);
		
}
