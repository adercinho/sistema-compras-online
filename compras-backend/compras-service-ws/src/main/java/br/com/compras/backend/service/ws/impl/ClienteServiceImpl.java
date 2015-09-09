package br.com.compras.backend.service.ws.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.backend.repository.ClienteRepository;
import br.com.compras.backend.service.ws.ClienteService;

@WebService(endpointInterface = "br.com.compras.backend.service.ws.ClienteService")
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	protected ClienteRepository repository;

	public Cliente findById(Long id) {
		return repository.findOne(id);
	}

	public Cliente[] findAll() {
		List<Cliente> lista = (List<Cliente>) repository.findAll();
		return lista.toArray(new Cliente[lista.size()]);
	}

	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	public void delete(Long id) {
		repository.delete(repository.findOne(id));
	}

	public Cliente[] findClientesQueRealizamReservaProdutos() {
		List<Cliente> lista = repository.findClientesQueRealizamReservaProdutos();
		return lista.toArray(new Cliente[lista.size()]);
	}
}
