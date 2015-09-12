package br.com.compras.frontend.client.rs;

import java.util.ArrayList;
import java.util.List;

import br.com.compras.backend.entity.Produto;
import br.com.compras.frontend.client.ServiceClient;
import br.com.compras.frontend.client.services.ProdutoService;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

public class ProdutoRest implements ProdutoService {

	private final String applicationURI;

	public ProdutoRest(String applicationURI) {
		this.applicationURI = applicationURI;
	}

	@Override
	public Produto findById(Long id) {
		ClientResponse response  = ServiceClient.getClientResponseGET(applicationURI + "/produto/" + id);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : c�digo do erro HTTP : " + response.getStatus());
		}

		try {
			return response.getEntity(Produto.class);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Produto> findAll() {
		ClientResponse response  = ServiceClient.getClientResponseGET(applicationURI + "/produto");

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : c�digo do erro HTTP : " + response.getStatus());
		}

		try {
			return response.getEntity(new GenericType<List<Produto>>(){});
		} catch (Exception e) {
			return new ArrayList<Produto>();
		}
	}

	@Override
	public Produto save(Produto entity) {
		ClientResponse response = ServiceClient.getClientResponsePOST(applicationURI + "/produto", entity);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : c�digo do erro HTTP : " + response.getStatus());
		}

		try {
			return response.getEntity(Produto.class);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		ClientResponse response = ServiceClient.getClientResponseDELETE(applicationURI + "/produto/" + id);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : c�digo do erro HTTP : " + response.getStatus());
		}
	}

	@Override
	public List<Produto> findProdutosMenorQueMilReais() {
		ClientResponse response  = ServiceClient.getClientResponseGET(applicationURI + "/produto/findProdutosMenorQueMilReais");

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : c�digo do erro HTTP : " + response.getStatus());
		}

		try {
			return response.getEntity(new GenericType<List<Produto>>(){});
		} catch (Exception e) {
			return new ArrayList<Produto>();
		}
	}
}
