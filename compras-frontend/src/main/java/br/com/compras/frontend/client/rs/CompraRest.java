package br.com.compras.frontend.client.rs;

import java.util.ArrayList;
import java.util.List;

import br.com.compras.backend.entity.Compra;
import br.com.compras.frontend.client.ServiceClient;
import br.com.compras.frontend.client.services.CompraService;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

public class CompraRest implements CompraService {

	private final String applicationURI;

	public CompraRest(String applicationURI) {
		this.applicationURI = applicationURI;
	}

	@Override
	public Compra findById(Long id) {
		ClientResponse response  = ServiceClient.getClientResponseGET(applicationURI + "/compra/" + id);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : c�digo do erro HTTP : " + response.getStatus());
		}

		try {
			return response.getEntity(Compra.class);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Compra> findAll() {
		ClientResponse response  = ServiceClient.getClientResponseGET(applicationURI + "/compra");

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : c�digo do erro HTTP : " + response.getStatus());
		}

		try {
			return response.getEntity(new GenericType<List<Compra>>(){});
		} catch (Exception e) {
			return new ArrayList<Compra>();
		}
	}

	@Override
	public Compra save(Compra entity) {
		ClientResponse response = ServiceClient.getClientResponsePOST(applicationURI + "/compra", entity);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : c�digo do erro HTTP : " + response.getStatus());
		}

		try {
			return response.getEntity(Compra.class);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		ClientResponse response = ServiceClient.getClientResponseDELETE(applicationURI + "/compra/" + id);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : c�digo do erro HTTP : " + response.getStatus());
		}
	}

	@Override
	public List<Compra> findComprasMaiorQueQuinhentosReais() {
		ClientResponse response  = ServiceClient.getClientResponseGET(applicationURI + "/compra/findComprasMaiorQueQuinhentosReais");

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : c�digo do erro HTTP : " + response.getStatus());
		}

		try {
			return response.getEntity(new GenericType<List<Compra>>(){});
		} catch (Exception e) {
			return new ArrayList<Compra>();
		}
	}

}
