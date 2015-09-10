package br.com.compras.online.client.rest;

import java.util.ArrayList;
import java.util.List;

import br.com.compras.backend.entity.Cliente;
import br.com.compras.online.client.ServiceClient;
import br.com.compras.online.client.services.ClienteService;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

public class ClienteRest implements ClienteService {
	
	private final String applicationURI;

	public ClienteRest(String applicationURI) {
		this.applicationURI = applicationURI;
	}
	
	@Override
	public Cliente findById(Long id) {
		ClientResponse response  = ServiceClient.getRestResponse(applicationURI + "/cliente/" + id);
		
		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : código do erro HTTP : " + response.getStatus());
		}
		
		try {
			return response.getEntity(Cliente.class);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Cliente> findAll() {
		ClientResponse response  = ServiceClient.getRestResponse(applicationURI + "/cliente");
		
		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : código do erro HTTP : " + response.getStatus());
		}
		
		try {
			return response.getEntity(new GenericType<List<Cliente>>(){});
		} catch (Exception e) {
			return new ArrayList<Cliente>();
		}
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
