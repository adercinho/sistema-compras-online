package br.com.compras.online.client.soap;

import java.util.List;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.online.client.services.ClienteService;

public class ClienteSoap implements ClienteService {

	private final String applicationURI;
	
	public ClienteSoap(String applicationURI) {
		this.applicationURI = applicationURI;
	}
	
	@Override
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente save(Cliente entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> findClientesQueRealizamReservaProdutos() {
		// TODO Auto-generated method stub
		return null;
	}
}
