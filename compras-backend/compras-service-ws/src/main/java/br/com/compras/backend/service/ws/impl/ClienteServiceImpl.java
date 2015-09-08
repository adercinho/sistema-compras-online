package br.com.compras.backend.service.ws.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.backend.repository.ClienteRepository;
import br.com.compras.backend.service.ws.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	protected ClienteRepository repository;

	@Override
	public Cliente findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) repository.findAll();
	}

	@Override
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public void delete(Long id) {
		repository.delete(repository.findOne(id));
	}

	@Override
	public List<Cliente> findClientesQueRealizamReservaProdutos() {
		return repository.findClientesQueRealizamReservaProdutos();
	}
}
