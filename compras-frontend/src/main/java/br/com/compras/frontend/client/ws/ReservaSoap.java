package br.com.compras.frontend.client.ws;

import java.util.List;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import br.com.compras.backend.entity.Reserva;
import br.com.compras.frontend.client.services.ReservaService;
import br.com.compras.frontend.client.ws.complextype.reserva.DeleteReservaRequest;
import br.com.compras.frontend.client.ws.complextype.reserva.GetReservaRequest;
import br.com.compras.frontend.client.ws.complextype.reserva.GetReservaResponse;
import br.com.compras.frontend.client.ws.complextype.reserva.ListAllReservaRequest;
import br.com.compras.frontend.client.ws.complextype.reserva.ListAllReservaResponse;
import br.com.compras.frontend.client.ws.complextype.reserva.SaveReservaRequest;
import br.com.compras.frontend.client.ws.complextype.reserva.SaveReservaResponse;

public class ReservaSoap extends WebServiceGatewaySupport implements ReservaService {

	private final String applicationURI;
	
	public ReservaSoap(String applicationURI) {
		this.applicationURI = applicationURI;
	}

	@Override
	public Reserva findById(Long id) {
		GetReservaRequest request = new GetReservaRequest();
		request.setId(id);
		GetReservaResponse response = (GetReservaResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
		return response.getReserva();
	}

	@Override
	public List<Reserva> findAll() {
		ListAllReservaRequest request = new ListAllReservaRequest();
		ListAllReservaResponse response = (ListAllReservaResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
		return response.getAllReservas();
	}

	@Override
	public Reserva save(Reserva entity) {
		SaveReservaRequest request = new SaveReservaRequest();
		request.setReserva(entity);
		SaveReservaResponse response = (SaveReservaResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(applicationURI));
		return response.getReserva();
	}

	@Override
	public void delete(Long id) {
		DeleteReservaRequest request = new DeleteReservaRequest();
		request.setId(id);
		getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(applicationURI));
	}
}
