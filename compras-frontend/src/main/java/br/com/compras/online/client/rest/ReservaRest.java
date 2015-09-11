package br.com.compras.online.client.rest;

import java.util.ArrayList;
import java.util.List;

import br.com.compras.backend.entity.Reserva;
import br.com.compras.online.client.ServiceClient;
import br.com.compras.online.client.services.ReservaService;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

public class ReservaRest implements ReservaService {

	private final String applicationURI;

	public ReservaRest(String applicationURI) {
		this.applicationURI = applicationURI;
	}

	@Override
	public Reserva findById(Long id) {
		ClientResponse response  = ServiceClient.getClientResponseGET(applicationURI + "/reserva/" + id);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : código do erro HTTP : " + response.getStatus());
		}

		try {
			return response.getEntity(Reserva.class);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Reserva> findAll() {
		ClientResponse response  = ServiceClient.getClientResponseGET(applicationURI + "/reserva");

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : código do erro HTTP : " + response.getStatus());
		}

		try {
			return response.getEntity(new GenericType<List<Reserva>>(){});
		} catch (Exception e) {
			return new ArrayList<Reserva>();
		}
	}

	@Override
	public Reserva save(Reserva entity) {
		ClientResponse response = ServiceClient.getClientResponsePOST(applicationURI + "/reserva", entity);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : código do erro HTTP : " + response.getStatus());
		}

		try {
			return response.getEntity(Reserva.class);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		ClientResponse response = ServiceClient.getClientResponseDELETE(applicationURI + "/reserva/" + id);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Falha : código do erro HTTP : " + response.getStatus());
		}
	}
}
